# Data analyser gRPC microservice

This is data analyser gRPC microservice
for [YouTube course](https://www.youtube.com/playlist?list=PL3Ur78l82EFA3fe4ltz7I4Z4_FKZ1PEBq).

This application receives data
from [Data generator gRPC service](https://github.com/IlyaLisov/data-generator-grpc-microservice)
with gRPC.

This application can return data to [Data store gRPC service](https://github.com/IlyaLisov/data-store-grpc-microservice)

### Usage

To start an application you need to pass variables to `.env` file.

You can find Docker compose file in `docker/docker-compose.yaml`.

Application is running on port `8082`.

All insignificant features (checkstyle, build check, dto validation) are not
presented.

#### Example:

```agsl
HOST=localhost:5437
POSTGRES_DB=sensor_data
POSTGRES_USERNAME=postgres
POSTGRES_PASSWORD=postgres
GRPC_PORT=8090
```

### Docker

You can run all course applications via `docker-compose.yaml` from `docker`
folder.

It contains all needed configs.

Note that all services must be in the same network to communicate with each
other.