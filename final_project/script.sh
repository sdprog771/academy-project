cd frontend
sudo apt install npm
npm install
cd ..
cd backend
sudo apt install maven
mvn clean install
cd ..
docker compose --env-file variables.env up --build -d
