FROM ubuntu:latest
LABEL authors="Sergey"
RUN apt update && apt upgrade -y && \
    apt install -y nginx

COPY /html/index.html /var/www/html/index.html
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
