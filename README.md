# Stock Ticker in Scala Play

This software was built in:
* JDK (SE) 1.8.0_222
* sbt 1.3.4
It was initialized with sbt new playframework/play-scala-seed.g8.

The code can be executed with sbt run from the root directory. It was tested in Ubuntu 16.04. 
Browse to localhost:9000 to try it out. The ticker updates every second.

You can update the ticker by entering the desired symbol into the text box and clicking Update Symbol. If you enter an invalid one, it will fail but there will be no validation errors on the frontend right now. It will function again if you enter a correct one though. 

When you update the symbol, it may take a few seconds before the ticker updates. This is one area for improvement.

Potential Improvements:
* Better validation on the frontend
* More synchronization between frontend updates and backend data feed. 
* Add the ability to show more stocks
* Better styled UI
* Implement serialization/deserializion on the backend with classes rather than Maps and strings
* More ability to configure runtime values
* More control over how stock ticker updates are sent to the frontend, like the ability to stop them or change the rate. 
* Add a process to allow different users to share the results of rest calls to the yahoo finance api, when they are looking at the same stocks. This could reduce the number of calls significantly if there were many simultaneous users.
* Update tests so they work with my UI.  
