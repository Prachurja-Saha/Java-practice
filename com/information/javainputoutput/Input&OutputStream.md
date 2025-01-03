# what is inputstream and outputstream?
In Java, InputStream and OutputStream are abstract classes that represent the foundation of byte stream I/O operations. 
They are part of the java.io package and are used for reading and writing binary data.

InputStream: Used for reading bytes from a source.
OutputStream: Used for writing bytes to a destination.
Common Usage: Reading/writing files, network communication, handling binary data.

# InputStream
InputStream is an abstract class that defines methods to read bytes from a source (e.g., file, network, memory). 
Some commonly used subclasses are:

FileInputStream: Reads data from a file.
ByteArrayInputStream: Reads data from a byte array.
BufferedInputStream: Adds buffering capabilities to the input stream.
DataInputStream: Allows reading Java primitives from an input stream.

`Common Methods`:
int read(): Reads the next byte of data from the input stream and returns it as an integer. Returns -1 when the end of the stream is reached.
int read(byte[] b): Reads some number of bytes from the input stream and stores them into the buffer array b.
void close(): Closes the input stream and releases any system resources associated with it.

# OutputStream
OutputStream is an abstract class that defines methods to write bytes to a destination (e.g., file, network, memory). 
Some commonly used subclasses are:

FileOutputStream: Writes data to a file.
ByteArrayOutputStream: Writes data to a byte array.
BufferedOutputStream: Adds buffering capabilities to the output stream.
DataOutputStream: Allows writing Java primitives to an output stream.

`Common Methods`:
void write(int b): Writes the specified byte to the output stream.
void write(byte[] b): Writes b.length bytes from the specified byte array to the output stream.
void close(): Closes the output stream and releases any system resources associated with it.

# Example provided in SerializationAndDeserializationTest.java class of FileInput and output stream