import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './AdminDashboard.css';

interface Vendor {
  id: string;
  vendorName: string;
  panNumber: string;
  gstNumber: string;
  status: string;
  createdAt: string;
}

interface DashboardStats {
  totalVendors: number;
  pendingVendors: number;
  approvedVendors: number;
}

const AdminDashboard: React.FC = () => {
  const [vendors, setVendors] = useState<Vendor[]>([]);
  const [stats, setStats] = useState<DashboardStats>({
    totalVendors: 0,
    pendingVendors: 0,
    approvedVendors: 0,
  });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchDashboardData = async () => {
      try {
        const [dashboardRes, vendorsRes] = await Promise.all([
          axios.get('/api/admin/dashboard'),
          axios.get('/api/admin/vendors'),
        ]);
        setStats(dashboardRes.data);
        setVendors(vendorsRes.data);
      } catch (err) {
        setError('Failed to load dashboard data');
        console.error(err);
      } finally {
        setLoading(false);
      }
    };

    fetchDashboardData();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="dashboard">
      <h1>Admin Dashboard</h1>
      <div className="stats-grid">
        <div className="stat-card">
          <h3>Total Vendors</h3>
          <p className="stat-value">{stats.totalVendors}</p>
        </div>
        <div className="stat-card">
          <h3>Pending Vendors</h3>
          <p className="stat-value pending">{stats.pendingVendors}</p>
        </div>
        <div className="stat-card">
          <h3>Approved Vendors</h3>
          <p className="stat-value approved">{stats.approvedVendors}</p>
        </div>
      </div>
      
      <div className="vendors-section">
        <h2>Vendor Management</h2>
        <table className="vendors-table">
          <thead>
            <tr>
              <th>Vendor Name</th>
              <th>PAN</th>
              <th>GST</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {vendors.map((vendor) => (
              <tr key={vendor.id}>
                <td>{vendor.vendorName}</td>
                <td>{vendor.panNumber}</td>
                <td>{vendor.gstNumber}</td>
                <td><span className={`badge ${vendor.status.toLowerCase()}`}>{vendor.status}</span></td>
                <td>
                  {vendor.status === 'PENDING' && (
                    <>
                      <button className="btn-approve">Approve</button>
                      <button className="btn-reject">Reject</button>
                    </>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AdminDashboard;
