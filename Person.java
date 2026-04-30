import java.util.Random;

/**
 * 
 * This class will be used as the <b>element</b> type that will be inserted into our <b>HashTable</b>.
 * 
 * @author Sameh Fakhouri
 *
 * @param <K>	This generic parameter specifies the <b>Key</b> type that will be used for
 *				the <b>HashTable</b>.
 */
public class Person<K> implements KeyedElementInterface<K> {
	
	private static final int NAME_LENGTH = 5;
	private static final Random randomNumberGenerator = new Random();
	
	private String firstName;
	private String lastName;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private K key;
	
	
	/**
	 * 
	 * This constructor is used by the copy method of this class
	 * 
	 * @param firstName		The person's first name
	 * @param lastName		The person's last name
	 * @param birthYear		The person's birth year
	 * @param birthMonth	The person's birth month
	 * @param birthDay		The person's birth day
	 * @param key			The person's unique key
	 * 
	 */
	private Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay, K key) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.key = key;
	}

	/**
	 * 
	 * This is the constructor for the class.
	 * 
	 * @param id	This parameter will be specified by the user. It is intended to be a 
	 * 				unique Key for each instance of the Person class. It is up to the user
	 * 				to assure the uniqueness of the Key.
	 */
	public Person(K key) {
		this.firstName	= createRandomName(NAME_LENGTH);
		this.lastName	= createRandomName(NAME_LENGTH);
		this.birthYear	= createRandomBirthYear();
		this.birthMonth = createRandomBirthMonth();
		this.birthDay   = createRandomBirthDay(this.birthMonth, this.birthYear);
		this.key		= key;
	}

	/**
	 * 
	 * This method is the implementation of the <b>KeyedElement</b> interface
	 * 
	 * @return	This method returns the unique <b>key</b> for this class instance.
	 * 
	 */
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public KeyedElementInterface<K> copy() {
		Person<K> copyPerson = new Person<K>(new String(this.firstName),
											 new String(this.lastName),
											 this.birthYear,
											 this.birthMonth,
											 this.birthDay,
											 this.key);
		return copyPerson;
	}

	@Override
	public String toString() {
		return "First Name: " + this.firstName + 
			   " | Last Name: " + this.lastName +
			   " | Birth Year: " + this.birthYear +
			   " | Birth Month: " + this.birthMonth +
			   " | Birth Day: " + this.birthDay +
			   " | ID Number: " + this.key;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthYear;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person<K> other = (Person<K>) obj;
			
			if (this.birthYear != other.birthYear) {
				return false;
			} else if ((this.firstName == null) && (other.firstName != null)) {
				return false;
			} else if (!this.firstName.equals(other.firstName)) {
				return false;
			} else if ((this.key == null) && (other.key != null)) {
				return false;
			} else if (!this.key.equals(other.key)) {
				return false;
			} else if ((this.lastName == null) && (other.lastName != null)) {
				return false;
			} else if (!this.lastName.equals(other.lastName)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private static String createRandomName(int length) {
		char[] chars = new char[length];

		for ( int i = 0 ; i < length ; i++ ) {
			int randomLetterIndex = randomNumberGenerator.nextInt(26);
			chars[i] = (char)(((int) 'a') + randomLetterIndex);
		}
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}
	
	private static int createRandomBirthYear() {
		return 1930 + randomNumberGenerator.nextInt(70);
	}
	
	private static int createRandomBirthMonth() {
		return randomNumberGenerator.nextInt(12) + 1;
	}
	
	private static int createRandomBirthDay(int month, int year) {
		if ((month == 1) || (month == 3) || (month == 5) || 
			(month == 7) || (month == 8) || (month == 10) || (month == 12)) {
			return randomNumberGenerator.nextInt(31) + 1;
		} else if (month == 2) {
 			if (isLeapYear(year)) {
 	 			return randomNumberGenerator.nextInt(29) + 1;
 			} else {
 	 			return randomNumberGenerator.nextInt(28) + 1;
 			}
		} else {
			return randomNumberGenerator.nextInt(30) + 1;
		}
	}
	
	private static boolean isLeapYear(int year) {
		if ((year % 4) != 0) {
			return false;
		} else if ((year % 25) != 0) {
			return true;
		} else if ((year % 16) != 0) {
			return false;
		} else {
			return true;
		}
	}
}
