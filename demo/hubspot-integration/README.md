# README.md

# HubSpot Integration API

This project is a Spring Boot application that integrates with the HubSpot API using OAuth 2.0 for authentication. It provides endpoints for generating authorization URLs, processing OAuth callbacks, creating contacts in HubSpot, and receiving webhooks for contact creation events.

## Features

- **Authorization URL Generation**: Endpoint to generate the OAuth 2.0 authorization URL.
- **OAuth Callback Processing**: Endpoint to handle the OAuth callback and exchange the authorization code for an access token.
- **Contact Creation**: Endpoint to create contacts in the HubSpot CRM.
- **Webhook Handling**: Endpoint to receive and process webhooks from HubSpot for contact creation events.

## Requirements

- Java 11 or higher
- Maven

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   cd hubspot-integration
   ```

2. Update the `application.properties` file with your HubSpot API credentials.

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Endpoints

- `GET /auth/authorize`: Generates the authorization URL.
- `GET /auth/callback`: Processes the OAuth callback.
- `POST /contacts`: Creates a new contact in HubSpot.
- `POST /webhook`: Receives webhooks from HubSpot.

## Documentation

For more details on the HubSpot API and OAuth 2.0, refer to the [HubSpot API documentation](https://developers.hubspot.com/docs/api/overview).

## License

This project is licensed under the MIT License. See the LICENSE file for more details.