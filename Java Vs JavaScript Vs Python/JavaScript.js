a=performance.now();
for(i=0;i<1000000000;i++){}
b=performance.now();
console.log('Execution time for JavaScript '+((b-a)/1000)+'seconds')


//run this in inspect tools console in browser
//output
//Execution time for JavaScript 2.0024100000008476seconds
