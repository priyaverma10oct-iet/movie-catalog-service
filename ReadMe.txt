Design & implement an API for movie in Java 9 or above with below endpoints
1. Creating movies
2. Updating movies
3. Fetching all movies
4. Fetch movies based on year
5. Fetch movies based on ratings


The Movie object will have 3 main attributes - name, year & rating.
Use a in-memory database to store and fetch the movies.
Ensure the application can be run locally and tested.
Ensure there is proper test coverage.

Make use of spring boot/spring webflux , Maven (if possible).

Build project using docker and place on your github and/or share the project link with above text into ReadME file.



####### Create Image -#########
Build Maven Module
docker build -f Dockerfile -t movie-catalog-service .

########### Docker Registry and command to run ##############
docker pull priyaverma10oct/movie-catalog-service:latest-2.0
docker run -p 8080:8080 -d priyaverma10oct/movie-catalog-service:latest-2.0