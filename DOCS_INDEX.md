# SRIVISWA-2025 Admin Module - Complete Documentation Index

## Project Overview
Complete educational institution ERP system with vendor management, expense tracking, and multi-role access control.

## Repository Structure

### Backend (Spring Boot)
- `pom.xml` - Maven dependencies and build configuration
- `src/main/java/com/sriviswa/controller/AdminController.java` - REST API endpoints for admin operations
- `src/main/java/com/sriviswa/service/AdminService.java` - Business logic and vendor management
- `src/main/java/com/sriviswa/repository/VendorRepository.java` - Data access layer
- `src/main/java/com/sriviswa/entity/Vendor.java` - JPA entity model
- `src/main/resources/application.properties` - Database and server configuration

### Frontend (React + TypeScript)
- `frontend/package.json` - NPM dependencies
- `frontend/src/components/AdminDashboard.tsx` - Admin dashboard component
- `frontend/src/components/VendorRegistration.tsx` - Vendor registration form (to be implemented)
- Additional UI components for various modules (planned)

### Database
- `database/schema.sql` - PostgreSQL/MySQL schema with vendors, organizations, users tables

### Documentation
- `README.md` - Project overview and introduction
- `DEPLOYMENT.md` - Complete deployment guide
- `COMPLETE_SETUP_INSTRUCTIONS.md` - Project setup instructions

## Documentation Files (To Be Added)

The following documentation files contain comprehensive implementation details and guides:

1. **QUICK_START_GUIDE.md** - Quick start guide for developers
2. **USER_CREDENTIALS_GUIDE.md** - Test user credentials and access instructions
3. **ERP_COMPLETE_IMPLEMENTATION_GUIDE.md** - Full ERP system implementation details
4. **ERP_FINAL_SUMMARY.md** - Final summary of ERP features
5. **ERP_TELUGU_QUICK_START.md** - Quick start guide in Telugu language
6. **IMPLEMENTATION_SUMMARY.md** - Implementation summary and progress
7. **OAUTH_IMPLEMENTATION_SUMMARY.md** - OAuth2 integration details
8. **BUGFIX_OAUTH_PROCESS_ERROR.md** - OAuth process error fixes
9. **BUGFIX_ORGANIZATION_REQUIRED.md** - Organization requirement fixes
10. **ORGANIZATION_FIX_DIAGRAM.md** - Organization data model diagrams
11. **TEST_AUTH_FIX.md** - Authentication testing guide
12. **UI_IMPROVEMENTS_SUMMARY.md** - UI/UX improvement details
13. **FIX_SUMMARY.md** - Summary of bug fixes and improvements
14. **Attributions.md** - Attributions and credits

## Key Features

### Admin Module
- Dashboard with vendor statistics
- Vendor management (approve/reject)
- Organization-based data filtering
- Role-based access control

### Data Isolation
- Each admin sees only their organization's vendors
- Database queries filter by organization_id
- Multi-tenant architecture support

### Business Logic
- Vendor status tracking (PENDING → APPROVED/REJECTED)
- Document validation (PAN, GST, Bank details)
- Audit trails with timestamps

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.1.5, Spring Data JPA, PostgreSQL
- **Frontend**: React 18, TypeScript, Axios, React Router
- **Database**: PostgreSQL/MySQL with proper indexing
- **Authentication**: Spring Security, JWT, OAuth2
- **Deployment**: Docker, Kubernetes, GitHub

## Setup Instructions

### Prerequisites
- Java 17+
- Node.js 18+
- PostgreSQL 13+
- Maven 3.8+
- Git

### Quick Setup
1. Clone the repository
2. Run database schema: `psql -U postgres -f database/schema.sql`
3. Build backend: `mvn clean install`
4. Run backend: `mvn spring-boot:run`
5. Install frontend: `cd frontend && npm install`
6. Start frontend: `npm start`

## API Endpoints

### Admin APIs
- `GET /api/admin/dashboard` - Get dashboard statistics
- `GET /api/admin/vendors` - List vendors for organization
- `GET /api/admin/vendors/{id}` - Get vendor details
- `PUT /api/admin/vendors/{id}/approve` - Approve vendor
- `PUT /api/admin/vendors/{id}/reject` - Reject vendor

## Testing

### Backend Tests
```bash
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## Contributing

Please follow the existing code structure and conventions when contributing.

## License

Proprietary - SRIVISWA Educational Enterprises

## Support

For issues and support, please contact the development team.
