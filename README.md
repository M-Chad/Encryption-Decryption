# Encryption-Decryption
An Encryption and Decryption app running multiple algorithms. I used the "strategy" design pattern to organize this app. This is a command line app that accepts the following arguments:



-out  : accepts a filepath to send the output of the encryption to.


-in   : accepts a text input file to encrypt a message.


-mode : can be encryption("enc") or decryption("dec").


-key  : an associated key for the cipher (must be a positive integer).


-data : command line data to be processed.


-alg  : your choice of algorithm, either a Ceaser cypher(shift) or Unicode encryption(uni).

Example:
input:
java Main -mode enc -key 5 -data "Welcome to my app!" -alg shift

output:
Bjqhtrj yt rd fuu
