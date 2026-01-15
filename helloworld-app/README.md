# Hello World Spring Boot Application

[![CI Pipeline - Build, Test & Security Scan](https://github.com/vishworks/devsecops/actions/workflows/ci.yml/badge.svg)](https://github.com/vishworks/devsecops/actions/workflows/ci.yml)  
[![CD Pipeline - Deploy to Environments](https://github.com/vishworks/devsecops/actions/workflows/cd.yml/badge.svg)](https://github.com/vishworks/devsecops/actions/workflows/cd.yml)
![Security](https://img.shields.io/badge/security-scanned-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)

A simple Hello World application demonstrating DevSecOps practices with CI/CD pipelines.

## 🚀 Features

- Spring Boot 3.2.0
- RESTful API endpoints
- Health checks and monitoring
- Docker containerization
- Comprehensive CI/CD pipelines
- Security scanning
- Code quality checks

## 📋 Prerequisites

- Java 17
- Maven 3.8+
- Docker (optional)

## 🛠️ Build and Run

### Local Development
```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Or run the JAR
java -jar target/helloworld-1.0.0.jar
```

### Using Docker
```bash
# Build Docker image
docker build -t helloworld-app .

# Run container
docker run -p 8080:8080 helloworld-app
```

## 🔗 Endpoints

- `GET /` - Hello World HTML page
- `GET /api/hello` - Hello World JSON response
- `GET /api/version` - Application version info
- `GET /actuator/health` - Health check endpoint

## 🧪 Testing

```bash
# Run unit tests
mvn test

# Run with coverage
mvn clean test jacoco:report
```

## 📊 CI/CD Pipelines

### CI Pipeline (ci.yml)
Runs on every push and pull request:
- Build and unit tests
- Code quality analysis
- Security scanning
- Docker image build
- Integration tests

### CD Pipeline (cd.yml)
Deploys to environments:
- **Development**: Automatic on main branch
- **Staging**: Automatic after dev
- **Production**: Manual approval required

## 🔒 Security

This project implements multiple security measures:
- OWASP Dependency Check
- Secret scanning (Gitleaks)
- Container vulnerability scanning (Trivy)
- Static code analysis (SpotBugs)
- Non-root container execution

## 📝 Assignment

See the presentation for step-by-step instructions on:
1. Setting up the project
2. Creating CI/CD workflows
3. Adding build badges
4. Introducing and fixing failures

## 🤝 Contributing

1. Create a feature branch
2. Make your changes
3. Ensure tests pass
4. Submit a pull request

## 📄 License

MIT License

