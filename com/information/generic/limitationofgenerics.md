# Limitation Of Generics
1. Generics Work Only with Reference Types
   We cannot use primitive data types like int, char. Test<int> obj = new Test<int>(20); C.T Error
   But primitive type arrays can be passed to the type parameter because arrays are reference types.
   ArrayList<int[]> a = new ArrayList<>(); b/c array is refernce type here int[] -> holds the address value of array obj

   2. Generic Types Differ Based on their Type Arguments
         During compilation, generic type information is erased which is also known as type erasure.
      class Test<T> {
   
          // An object of type T is declared
          T obj;
          Test(T obj) { this.obj = obj; } // constructor
          public T getObject() { return this.obj; }
   
      }

       class Geeks {
           public static void main(String[] args)
           {
           // instance of Integer type
           Test<Integer> iObj = new Test<Integer>(15);
           System.out.println(iObj.getObject());
        
           // instance of String type
           Test<String> sObj
               = new Test<String>("GeeksForGeeks");
           System.out.println(sObj.getObject());
           iObj = sObj; // This results an error
           }
       }
      error:
      incompatible types:
      Test cannot be converted to Test
      Explanation: Even though iObj and sObj are of type Test, they are the references to different types because their 
      type parameters differ. Generics add type safety through this and prevent errors.
3. Type Parameter Naming Conventions

    T: Type
    E: Element
    K: Key
    N: Number
    V: Value