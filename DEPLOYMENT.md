# SRIVISWA 2025 Admin Module - Deployment Guide

## Complete Project Structure

### Backend (Spring Boot)
- `pom.xml` - Maven project configuration with Spring Boot 3.1.5
- `src/main/java/com/sriviswa/controller/AdminController.java` - REST API endpoints
- `src/main/java/com/sriviswa/service/AdminService.java` - Business logic for admin operations
- `src/main/java/com/sriviswa/repository/VendorRepository.java` - JPA repository interface
- `src/main/java/com/sriviswa/entity/Vendor.java` - Vendor entity with JPA mappings
- `src/main/resources/application.properties` - Database and server configuration

### Frontend (React + TypeScript)
- `frontend/package.json` - NPM dependencies (React 18, Axios, React Router)
- `frontend/src/components/AdminDashboard.tsx` - Main admin dashboard component

### Database (PostgreSQL/MySQL)
- `database/schema.sql` - Complete database schema with vendors, organizations, users tables
- Includes foreign keys, indexes, and unique constraints

## Setup Instructions

### 1. Database Setup
```bash
# Create database
mysql -u root -p < database/schema.sql

# Or for PostgreSQL
psql -U postgres -f database/schema.sql
```

### 2. Backend Setup
```bash
# Build project
mvn clean install

# Run Spring Boot application
mvn spring-boot:run

# Application will start on http://localhost:8080/api
```

### 3. Frontend Setup
```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm start

# Build for production
npm run build
```

## Key Features

### Organization-Filtered Data
- Admin users can only view vendors from their own organization
- Database queries filter by organization_id

### Vendor Management Endpoints
- GET /api/admin/dashboard - Dashboard statistics
- GET /api/admin/vendors - List organization vendors
- GET /api/admin/vendors/{id} - Get vendor details
- PUT /api/admin/vendors/{id}/approve - Approve vendor
- PUT /api/admin/vendors/{id}/reject - Reject vendor

### Database Validation
- PAN and GST numbers are unique per organization
- Vendor status transitions (PENDING → APPROVED/REJECTED)
- Audit timestamps (created_at, updated_at)

## Business Logic Implementation

### Admin Dashboard
- Displays total vendors, pending, and approved counts
- Shows filterable vendor list with status badges
- Approve/Reject buttons only visible for PENDING vendors

### Data Isolation
- Users authenticated with organization_id
- All queries filtered by organizationId
- Frontend receives only org-specific data

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.1.5, Spring Data JPA
- **Frontend**: React 18, TypeScript, Axios
- **Database**: PostgreSQL/MySQL
- **Security**: Spring Security, Role-based access control

## Configuration

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sriviswa_2025
spring.datasource.username=postgres
spring.datasource.password=your_password
server.port=8080
```

## Testing

### Backend API Testing
```bash
curl http://localhost:8080/api/admin/dashboard
curl http://localhost:8080/api/admin/vendors
```

### Frontend Testing
Access http://localhost:3000 in browser after npm start

## Troubleshooting

1. Database connection errors - verify credentials in application.properties
2. CORS errors - ensure frontend proxy configured correctly
3. Missing dependencies - run mvn clean install and npm install

## Deployment

For production:
1. Build backend: `mvn clean package`
2. Build frontend: `npm run build`
3. Deploy JAR to server
4. Serve frontend static files from web server
