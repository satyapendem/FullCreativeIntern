function University( colName, colAddress, colId ) {
 
  this.colName = colName;
  this.colAddress = colAddress;
  this.colId = colId;
 
  this.toString = function () {
    return this.colName +" " + "And Id is" +this.colId;
  };
}
 

var college1 = new University( "KIET", "KKD", 249 );
var college2 = new University( "Aditya", "KKD", 255 );
 

console.log( college1.toString() );
console.log( college2.toString() );