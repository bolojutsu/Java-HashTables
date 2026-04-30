public interface HashTableDriverInterface {
	
	/**
	 * 
	 * This <code>enum</code> is used to specify which test scenario will be executed.
	 * 
	 * The <code>TestType</code> enum has the following choices:
	 * 							<ol>
	 * 								<li>Insert</li>
	 * 								<li>Get</li>
 	 * 								<li>Remove</li>
	 * 							</ol>
	 *
	 */
	public static enum TestType {Insert, Get, Remove};
	
	/**
	 *
	 * This method is used to create array with the 
	 * specified number of <code>Person&lt;Integer&gt;</code> instances.
	 * 
	 * @param numPeople	The number of <code>Person&lt;Integer&gt;</code> instances to create.
	 * 
	 * @return	This method returns a <code>Vector&lt;Person&lt;Integer&gt;&gt;</code> with the 
	 * 			specified number of <code>Person&lt;Integer&gt;</code> instances.
	 */
	public Person<Integer>[] createPersons(int numPeople);
	
	/**
	 * 
	 * This method creates the buckets that are needed for the
	 * <code>HashTable&lt;Person&lt;Integer&gt;, Integer&gt;</code>.
	 * 
	 * @param numBuckets	The number of buckets needed for the <code>HashTable&lt;Person&lt;Integer&gt;, Integer&gt;</code>.
	 * 	
	 * @return	An array of <code>LinkedList&lt;Person&lt;Integer&gt;, Integer$gt;</code> containing the specified number
	 * 			of <code>LinkedList&lt;Person&lt;Integer&gt;, Integer$gt;</code> instances.
	 */
	public LinkedList<Person<Integer>, Integer>[] createBuckets(int numBuckets);
	
	/**
	 * 
	 * This method is used to create a <code>HashTable&lt;Person&lt;Integer&gt;, Integer&gt;</code>
	 * for the specified <b>testType</b>.
	 * 
	 * @param testType	The type of test for the created HashTable.
	 * 					<dl>
	 * 						<dt>
	 * 							Insert
	 * 						</dt>
	 * 						<dd>
	 * 							The returned HashTable must be empty
	 * 						</dd>
	 * 						<dt>
	 * 							Get
	 * 						</dt>
	 * 						<dd>
	 * 							The returned HashTable must contain the specified number of 
	 * 							<code>Person&lt;Integer&gt;</code> instances.
	 * 						</dd>
	 * 						<dt>
	 * 							Remove
	 * 						</dt>
	 * 						<dd>
	 * 							The returned HashTable must contain the specified number of 
	 * 							<code>Person&lt;Integer&gt;</code> instances.
	 * 						</dd>
	 * 					</dl>
	 * @param numPeople	The number of <code>Person&lt;Integer&gt;</code> instances to include in
	 * 					the returned HashTable.
	 * 
	 * @return			This method will return an instance of <code>HashTable&lt;Person&lt;Integer&gt;, Integer&gt;</code>
	 * 					containing the specified number of <code>Person&lt;Integer&gt;</code> instances
	 */
	public HashTable<Person<Integer>, Integer> createHashTable(TestType testType, int numPeople);
	
	/**
	 * 
	 *
	 * <p>
	 * This method is called to run a particular <b>testType</b> on a <b>HashTable</b> for the specified 
	 * <b>numberOfTimes</b>. 
	 * </p>
	 * 
	 * <p>
	 * This method repeats the following <code>numberOfTimes</code>:
	 * <ul>
	 * <li>
	 * Obtain and initialize a HashTable for the <b>testType</b>
	 * </li>
	 * <li>
	 * Make a copy of the initialized HashTable
	 * </li>
	 * <li>
	 * Run the specified <b>testType</b> 
	 * </li>
	 * <li>
	 * Make a copy of HashTable after <b>testType</b> is completed
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * @param testType		The test type to be run.
	 * 
	 * @param numPeople		The number of <code>Person&lt;Integer&gt;</code> instances to include 
	 * 						in the test.
	 * 
	 * @param numberOfTimes The type of test case being run. See the enum {@link TestType}.
	 *
	 * 
	 * @return The method must return an array of <b>Object</b> containing the following:
	 * <ul>
	 * <li>
	 * array[0] - Must contain a copy of the initialized HashTable for the first test.
	 * </li>
	 * <li>
	 * array[1] - Must contain a copy of the HashTable after the first test.
	 * </li>
	 * <li>
	 * array[2] - Must contain a copy of the initialized HashTable for the second test.
	 * </li>
	 * <li>
	 * array[3] - Must contain a copy of the HashTable after the second test.
	 * </li>
	 * <li>
	 * ...
	 * </li>
	 * <li>
	 * array[numberOfTimes*2-2] - Must contain a copy of the initialized HashTable before for the last test.
	 * </li>
	 * <li>
	 * array[numberOfTimes*2-1] - Must contain a copy of the HashTable after the last test.
	 * </li>
	 * </ul> 
	 *
	 */
	public Object[] runTestCase(TestType testType, int numPeople, int numberOfTimes);
}
