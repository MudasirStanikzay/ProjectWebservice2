🔧 Lab 2 – Microservices, API Gateway & Inloggning

I den här labben bygger du ett enkelt system med microtjänster som kommunicerar via en API-gateway. Tjänsterna paketeras som Docker-images och körs som containrar. 
En klientapplikation (clientservice) simulerar en extern användare och körs lokalt på din dator.

🛠️ Så här kommer du igång:

1. Bygg Docker-images (alla utom clientservice):
   Öppna terminalen i projektets rotmapp och kör:

./build-images.ps1
2. Starta microtjänsterna i containrar:
   Från samma mapp:

docker-compose up
3. Kör clientservice:
   Starta klienten som en lokal Java-applikation från din IDE eller via terminalen.

🌐 Utforska applikationen

Steg 1:
Öppna webbläsaren och gå till:
http://localhost:7000
(clientservice-gränssnittet)

Steg 2:
Du kommer automatiskt bli omdirigerad till authservice på:
http://localhost:9000

Logga in med:

user: user  
password: password

Steg 3: 
Efter lyckad inloggning skickas du tillbaka till localhost:7000/
Här visas:

- Ditt access token

- Ditt användarnamn

- Dina rättigheter (access scope)

Steg 4:

Med ett giltigt token kan du nu navigera vidare till tjänsterna:

🎭 JokeService – Få ett slumpmässigt skämt

💬 QuoteService – Få ett inspirerande citat
