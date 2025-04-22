FROM clojure:openjdk-17-lein
WORKDIR /app

COPY . .
RUN lein deps

EXPOSE 3000
CMD ["lein", "run"]