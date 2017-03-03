# Exercise
Java program to aggregate data from provided files text files

-DistilLogReader is the driver class.

-POJO class for WebRequest.

-Have written DistilLogInterface and DistilLogImplentation class. 

-Input data placed in testdata folder

-Utilized Joda time library

-Here in this program, I have used Java SE 8 Streams for processing of data.


##*Total number of requests*
This is calculated with number of lines in the files. For this once each line(WebRequest) is added into List, we found a count of that list grouped by domainName.

##*Average requests per hour*
First I calculated the number of Days between max and min dates in list.
Total number of requests/(Number of hours in a day*Number of days).
Or
If needed in different way, average for each hour in 24 hour format. We can iterate for each hour from total requests and divide by number of days.

##*Maximum requests per hour*
We can find the number of requests per hour in 24 hour format for each domain and place it in Map. Then for each domain we can calculate Maximum requests among each hour in day.



