ruzzle-solver
=============
Ruzzle is a [boggle] (http://en.wikipedia.org/wiki/Boggle) clone which runs on the iPhone. Since I'm apparently terrible at the
game myself, I decided to write a program to solve it for me.

Note that the sample dictionary included only has ~45,000 words in it - more than enough to enter in two minutes anyway.

Usage (requires [sbt](http://www.scala-sbt.org/)):
-----
> $ sbt

> \> run

Sample run
----------
\> run

[info] Running ruzzlesolver.RuzzleSolver   
Enter row 1's letters: euic  
Enter row 2's letters: fral  
Enter row 3's letters: itrt  
Enter row 4's letters: ltes

Search took: 9749 ms  
Found 153 words:  

List(clatter, carters, fritter, fitters, filters, restart, litters, lifters, literal, starter, claire, carter, 
caters, fitter, friars, filter, ferret, ritter, raters, rarest, attest, arrest, attire, alters, latter, latest, 
italic, retail, retire, tatter, liters, litter, lifter, irate, cater, clare, carts, caret, cares, frail, friar, 
rates, rater, rites, alter, later, liars, lares, irate, terra, trial, terre, trail, rates, terra, terre, trail, 
lifer, liter, terra, terre, trail, starr, serra, start, state, stair, stare, errs, eric, care, cars, carl, cart, 
carr, cats, fire, frau, rift, rats, rare, rica, rate, rite, rail, ares, arts, late, lars, liar, laue, lair, true, 
tart, test, tate, tail, tilt, tire, rats, rare, rate, rest, rail, tart, tate, tail, life, lift, test, tilt, tire, 
star, era, err, uri, ire, ira, car, cat, fir, fit, fur, rue, rat, ate, are, art, ali, air, ail, lac, ire, ira, tar, 
tau, tit, rat, tar, tau, lit, tit, era, err, set, fe, re, at, al, it, if, re, et)

