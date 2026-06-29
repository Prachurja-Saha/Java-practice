
- String Constant pool/ String literal pool (SCP) -> Stored String literal obj
- Not Applicable for garbage collection

SCP is present in Heap area after 1.7 version before 1.7 version -> method area

2 ways to create an object of String [by literal and by new keyword]


1. String s1 = new String("Deepak") -> {    // Here "Deepak" is string literal so it will create inside scp also and due
                                         Heap:{                                     to new keyword outside scp also 2 obj
     new keyword  [s1 is reference]  -->  {Deepak Object1}
                                             SCP: {
created by String literal [JVM internally refer] --> {Deepak Object2} // literal obj
                                                  }
                                               }
                                        }
     two Object will be created
     * SCP object cannot be deleted by garbage collection

2. String s2 = "Rahul" -> Only one object will be created
        {
          Heap:{ SCP:{ 
  [s2 Refer] -->        {Rahul obj1 } // literal obj
                      } 
                }
        }
 * example -> 
 * String x = "AMIT" -> it will create new literal obj in SCP [x is the reference]
 * String y = "AMIT" -> it won't create new literal obj b/c "AMIT" is already present in SCP [y also is the reference]
 * https://www.tldraw.com/r/b1GD09p6Yoe092Ckr5htf?v=-209,-88,1365,632&p=page
 * 2 Reference one obj



