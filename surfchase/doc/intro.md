# Introduction to surfchase

Surfchase is a program that simulates a surfer trying to find the best waves. Given a set of beaches, decide which beach will be the best for the surfer. After initial setup, send 100 surf events, which will update the initial data, and after each event the surfer will have to decide where to go, based on the most promising surf event.

So, for one round, load the initial data, then decide where to go. That is the first goal.

Next, get Cider working for emacs. Create different scripts to swap out golang config and clojure config. (softlink emacs.d to different directories, depending.) Supposedly Cider allows you to run and build more quickly than always waiting on lein run.

Next, get a conf dir with both emacs and lein configs. Use softlinks to link to these git dirs.

Next, research core.async to get events going as soon as possible. This is the meat of the program and why it might be interesting to me at all.

core.async

[Clojure core.async Channels - introductory blog post by Rich Hickey](http://clojure.com/blog/2013/06/28/clojure-core-async-channels.html)


Later, use korma sql to load the JSON data and use to store and query. For now, use sqlite.
