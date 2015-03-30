<html> 

<head> 

<!-- 
No matter which you select 
as "best answer" - pick one. 
--> 

<style> 
/**** navigation menu links ****/ 

/* container for menu elements */ 
#navMenu { 
border: 0; 
height: 200px; 
left: 2px; 
margin: 0; 
position: absolute; 
top: 70px; 
width: 136px; 
z-index: 1; 
} 

/* general nav anchor properties */ 
#navMenu a { 
background-color: #8AB; 
border: 1px solid black; 
color: black; 
display: block; 
font-family: Helvetica, sans-serif; 
font-size: 12px; 
font-weight: bold; 
height: 16px; 
margin: 0 0 5px 0; 
padding: 2px 0 2px 4px; 
text-decoration: none; 
width: 132px; 
} 

/* color-swap to show "active" choice */ 
#navMenu a:hover { 
background-color: white; 
} 

/* reset color of nav-link when on 
corresponding page - don't use white 
page body needs id "page?" for selector */ 
#page1 #page1Link, 
#page2 #page2Link, 
#page3 #page3Link, 
#page4 #page4Link { 
background-color: #DEF; 
} 

/**** page content area ****/ 
#content { 
border: 1px solid blue; 
font-family: Helvetica, sans-serif; 
font-size: 12px; 
height: 286px; 
left: 160px; 
padding: 0 12px 0 12px; 
position: absolute; 
top: 70px; 
width: 361px; 
z-index: 2; 
} 
</style> 

<script> 
</head> 

<body id="page1"> 
<h1> Some Site Global Header Goes Here</h1> 
<p id="navMenu"> 
<!-- line-breaks keep margins from collapsing in IE6 --> 
<a id="page1Link" href="page1.html">Page 1 
</a> 
<a id="page2Link" href="page2.html">Page 2 
</a> 
<a id="page3Link" href="page3.html">Page 3 
</a> 
<a id="page4Link" href="page4.html">Page 4 
</a> 
</p> 
<div id="content"> 
<h2>Header for Page 1 goes here</h2> 
<p> 
Page 1 content goes here... 
</p> 
</div> 
</body> 

</html>