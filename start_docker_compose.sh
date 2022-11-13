export POSTGRES_USER=postgres
export POSTGRES_PASSWORD=postgres
export DATASOURCE_URL=jdbc:postgresql://clients-database:5433/clients?currentSchema=clients
docker build -t clients_api .
docker-compose up -d --force-recreate