# ANT FILE CRC32

Library for calculating file CRC32 hashes in ANT

## Usage

	<!-- Ensure that the JAR is in your classpath -->
	<taskdef resource="ant-file-crc32.xml" />
	...
	<crc32 file="file path" property="MyProp" />
	<echo>File CRC32 checksum is ${MyProp}</echo>
   
 Will output:
 
   [echo] File CRC32 checksum is 3243324211 