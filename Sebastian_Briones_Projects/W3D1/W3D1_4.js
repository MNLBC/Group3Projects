//indexOf() - returns the index of the first occurrence of one string inside another, returns -1 if there is no match

var myString = 'Hello Sebastian';
var position = myString.indexOf('Sebastian'); //6


//lastIndexOf()  - returns the index of the last occurrence of one string inside another

myString = 'Sebastian, Hello Sebastian!';
position = myString.lastIndexOf('Sebastian'); //17

//substring() - accepts two parameters, the start position and the character after the last character desired in the substring

var myString = 'JavaScript';
var mySubString = myString.substring(0,4);
alert(mySubString); //Java

//substr() - accepts two parameters , the start position and the number of characters afterwards
var mySubString = myString.substr(0,4);
alert(mySubString); //Java


//charAt - accpets one parameter, the index of the character you want returned from the string

var myString = 'Sebastian';
alert(myString.charAt(5)); //t

