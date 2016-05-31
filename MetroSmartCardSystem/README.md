# Metro Smart Card System


## Given :
Implement a 'Metro Smart Card System' (MSCS) for a metro city. Assume there is a single metro line covering 10 stations linearly. 

The stations names are
```
A1, A2, A3, A4, A5, A6, A7, A8, A9, A10
```
- - - -

The travel can be in any direction


Travelers have smart cards that behave just like any regular debit card that has an initial balance
when purchased. Travelers swipe-in when they enter a metro station and swipe-out when they exit. 
The card balance is automatically updated at swipe-out.


## Objective
Objective is to create an automated system that has following functionalities:
* Card should have a minimum balance of Rs 5.5 at swipe-in. 
* At swipe-out, system should calculate the fare based on below strategies set at the start of the day.
  * > Weekday – Rs. 7 * (Number of stations traveled)
  * > Weekend – Rs. 5.5 * (Number of station traveled if it's Saturday or Sunday)
  * > (* there can be more such fare strategies in future)
* The fare must be deducted from the card. Card should have the sufficient balance otherwise user should NOT be able to exit.

* Additionally, system needs to have functionality to generate some statistics/reports defined below. So,
  system needs to provide following APIs
  • API to get total foot-fall (swipe-in + swipe-out) for a given station.
  • API to generate a “per-card report” on demand: It should prints the following information on console:

  * > Card <number> used to travel from station \<source_station> to station  \<destination_station>. Fare is Rs \<x> and balance on the card is \<Rs x>.




