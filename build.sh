cd ondetem-client
ember build
cd ..
cd ondetem-server
./gradlew build
rm -rf ./public
cp -r ../ondetem-client/dist ./public
touch ./public/.gitkeep
