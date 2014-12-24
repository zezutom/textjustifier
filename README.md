Text Full Justification
=======================

This is my implementation of a full text justification, example:

```java
String text = "Lorem impsum..." // etc. we all know how it goes

// Let's create a block 80 characters wide
System.out.println(new TextJustifier().justify(text, 80));
```

Output
```
Lorem  ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare non massa
id sodales. Nunc in erat suscipit, rutrum leo eu, molestie elit. Nullam id risus
nulla.  Cras  varius libero at ultrices rutrum. Sed imperdiet eleifend massa sed
tincidunt.  Phasellus  vulputate  nisl  ex,  quis  varius risus pellentesque in.
Aenean  hendrerit  velit vitae nisi rhoncus dignissim. Integer in rutrum turpis.
Donec  in  sodales est. Sed eros magna, egestas vitae varius vitae, viverra eget
lacus.   Donec   vel   magna   non   neque   convallis  congue  sed  eget  urna.
```

This class is all you need, enjoy: [TextJustifier](../master/src/main/java/org/zezutom/justification/TextJustifier.java)
