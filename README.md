# FeSafe
Overview:

Presenting an application which can cater for women in distress.

With wide ranging features and highly scalable structure FeSafe makes sure that you get the comfort you deserve.

Features:
SOS button: When activated it switches on a siren and sends a text message to some selected contacts. This can be useful in a lot of emergencies.

Nearest hospitals and police stations: The user’s location is detected by the application and a list of hospitals and police stations is sent to the user. 

Share your grievances: This would allow a person to send any kind of complaint to a fixed set of Email addresses.

Helpline: This feature lists out a lot of websites/numbers of NGOs and government which are committed to women’s safety. 

Notifications based on location: Based on user’s location, notifications are sent covering the major news articles of nearby places. This news is updated periodically. News is scraped from leading news websites.

Tip of the day: This feature will help in increasing the general awareness of an individual. These tips can cover a wide range of topics.


Scope for improvement:
Need to extend this application to more platforms like iOS and Windows devices

Adding additional features to make an entire women-centric platform

Making a web API for the application

**How to run:**
Clone the github repository into your desktop

The news.py Python file inside sources/scraping is used to scrape the news from the current city location and this is written into the news.txt file

The c++ file process.cpp opens the tips.txt file and reads them based on the current day. The current day tip is then written into tipoftheday.txt

Execute these 2 files to stay updated on the information

To run the app install the .apk file or open the project in android studio and create an apk
