var Person = function( firstName, lastName ){
 
  this.firstName = firstName;
  this.lastName = lastName;
  this.gender = "male";
 
};

var emp = new Person("satya","pendem");

var Superhero = function( firstName, lastName, powers ){
 
    // Invoke the superclass constructor on the new object
    // then use .call() to invoke the constructor as a method of
    // the object to be initialized.
 
    Person.call( this, firstName, lastName );
 
    // Finally, store their powers, a new array of traits not found in a normal "Person"
    this.powers = powers;
};
 
Superhero.prototype = Object.create( Person.prototype );
var superman = new Superhero( "satya", "pendem", ["flight","heat-vision"] );
console.log( superman );