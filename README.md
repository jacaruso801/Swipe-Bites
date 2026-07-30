# 🍽️ Swipe Bites

> A full-stack web application that helps groups decide where to eat by swiping through restaurant choices together.

Swipe Bites is inspired by the simplicity of modern swipe-based apps, allowing users to create groups, add restaurants, vote with left/right swipes, and quickly discover restaurants everyone agrees on.

This project is being built as a production-style portfolio application to demonstrate modern full-stack software engineering, cloud infrastructure, and DevOps practices.

---

## ✨ Features

### Current
- User authentication
- Create and join restaurant groups
- Add restaurants to a shared list
- Swipe left or right on restaurant cards
- View group match results

### Planned
- Restaurant search integration (Google Places/Yelp)
- Real-time group updates
- Distance, cuisine, and price filtering
- Favorites and restaurant history
- Dark mode
- Mobile-first responsive design
- Analytics dashboard

---

# 🏗️ Architecture

```
                React + TypeScript
                       │
                  REST API
                       │
            Spring Boot (Java)
                       │
                  PostgreSQL
                       │
                    Docker
                       │
             GitHub Actions CI/CD
                       │
                     AWS
```

---

# 🛠 Tech Stack

## Frontend

- React
- TypeScript
- Vite
- React Router
- TanStack Query
- Tailwind CSS

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven

## Database

- PostgreSQL

## DevOps

- Docker
- Docker Compose
- GitHub Actions
- Terraform *(planned)*
- AWS *(planned)*

## Testing

- JUnit
- Mockito
- React Testing Library
- Vitest

---

# 📁 Project Structure

```
restaurant-swipe/
│
├── frontend/          # React application
├── backend/           # Spring Boot API
├── infrastructure/    # Terraform & cloud resources
├── docker/            # Docker configuration
├── docs/              # Architecture and documentation
└── .github/           # CI/CD workflows
```

---

# 🚀 Goals

This project focuses on demonstrating professional software engineering practices rather than simply building an application.

Areas of focus include:

- Clean Architecture
- RESTful API design
- Authentication & Authorization
- Containerization
- Infrastructure as Code
- CI/CD Automation
- Cloud Deployment
- Automated Testing
- Git Workflow
- Documentation

---

# 📈 Roadmap

## Phase 1
- [x] Project setup
- [x] Docker environment
- [x] Spring Boot API
- [x] PostgreSQL integration
- [ ] React frontend
- [ ] User authentication

## Phase 2
- [ ] Group creation
- [ ] Restaurant management
- [ ] Swipe interface
- [ ] Match algorithm

## Phase 3
- [ ] Google Places integration
- [ ] Live updates
- [ ] User profiles
- [ ] Deployment to AWS

## Phase 4
- [ ] Terraform infrastructure
- [ ] Kubernetes deployment
- [ ] Monitoring & dashboards

---

# 📚 What I'm Learning

This project is an opportunity to deepen my experience with:

- React
- TypeScript
- Spring Boot
- PostgreSQL
- Docker
- Kubernetes
- Terraform
- AWS
- GitHub Actions
- CI/CD
- Software Architecture

---

# 🤝 Why This Project?

Rather than building a simple CRUD application, I wanted to create something that demonstrates how modern production applications are designed and deployed.

The goal is to showcase:

- Full-stack development
- API design
- Secure authentication
- Cloud-native deployment
- DevOps workflows
- Infrastructure automation
- Clean code and maintainable architecture

---

# 📄 License

This project is licensed under the MIT License.
