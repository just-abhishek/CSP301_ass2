
import java.util.LinkedList;

import prefuse.data.Table;
import prefuse.data.io.CSVTableReader;
import prefuse.data.io.DataIOException;

public class Alliance {

	
	@SuppressWarnings("rawtypes")
	public static float average(LinkedList l) {
		double sum = 0;
		float len = l.size();
		if (len == 0) {
			return (float) 0.0;
		}
		for (int i = 0; i < len; i++) {
			int t = (int) l.get(i);
			sum = sum + t;
		}
		float f = (float) sum;

		return (Math.round(f / len));

	}

	/**
	 * Main function
	 * Calculates alliance specific data
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// reads file
		Table t1 = new Table();
		CSVTableReader t = new CSVTableReader();
		try {
			t1 = t.readTable("MPTrack-15.csv");
		} catch (DataIOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!!");
			System.exit(0);
		}

		int a = 552;
		LinkedList<String> l = new LinkedList<String>();
		LinkedList<Object> l_age;
		LinkedList<String> upa = new LinkedList<String>();
		LinkedList<String> others = new LinkedList<String>();
		LinkedList<String> nda = new LinkedList<String>();
		LinkedList<String> third = new LinkedList<String>();
		
		// All the members of United Progressive Alliance(UPA)
		
		upa.add("Indian National Congress");
		upa.add("All India Trinamool Congress");
		upa.add("Dravida Munnetra Kazhagam");
		upa.add("Nationalist Congress Party");
		upa.add("Rashtriya Lok Dal");
		upa.add("Jammu and Kashmir National Conference");
		upa.add("Jharkhand Mukti Morcha");
		upa.add("Muslim League Kerala State Committee");
		upa.add("All India Majlis-E-Ittehadul Muslimmen");
		upa.add("Kerala Congress (M)");
		upa.add("Viduthalai Chiruthaigal Katchi");
		upa.add("Samajwadi Party");
		upa.add("Bahujan Samaj Party");
		upa.add("Rashtriya Janata Dal");
		upa.add("Janata Dal (Secular)");
		upa.add("Nagaland People's Front");
		upa.add("Bodoland People's Front");
		upa.add("Swabhimani Paksha");
		upa.add("Bahujan Vikas Aaghadi");
		upa.add("Assam United Democratic Front");
		upa.add("Sikkim Democratic Front");

		// All the members of National Democratic Alliance(NDA)
		
		nda.add("Bharatiya Janata Party");
		nda.add("Shiv Sena");
		nda.add("Swtantra Bharat Paksh");
		nda.add("Indian National Lok Dal");
		nda.add("Mizo National Front");
		nda.add("Janata Dal (United)");
		nda.add("Shiromani Akali Dal");
		nda.add("Asom Gana Parishad");
		nda.add("Telangana Rashtra Samithi");

		// All the members of United National Progressive Alliance(UNPA)		

		third.add("Communist Party of India (Marxist)");
		third.add("Communist Party of India");
		third.add("Revolutionary Socialist Party");
		third.add("All India Forward Bloc");
		third.add("Biju Janata Dal");
		third.add("Pattali Makkal Katchi");
		third.add("Telugu Desam Party");
		third.add("All India Anna Dravida Munnetra Kazhagam");
		third.add("Haryana Janhit Congress");
		third.add("Marumalarchi Dravida Munnetra Kazhagam");
		
		// Other political parties
		
		others.add("Jharkhand Vikas Morcha (Prajatantrik)");
		others.add("Independent");
		others.add("Lok Janasakti Party");
		others.add("Yuvajana Sramika Rythu Congress Party");


		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;

		// counts members of all the alliances
		for (int i = 0; i < a; i++) {
			Object abc = t1.get(i, 6);
			if (upa.contains(abc)) {
				count1++;

			} else if (nda.contains(abc)) {
				count2++;

			} else if (third.contains(abc)) {
				count3++;

			} else if (others.contains(abc)) {
				count4++;
			} else {
				// System.out.println(abc);
			}

		}

		
		// Selects all the parties and defines their alliance
		Object s, s1 = new Object();
		for (int i = 0; i < a; i++) {
			s = t1.get(i, 6);
			if (!l.contains(s)) {
				l.add((String) s);
			}
		}

		for (int i = 0; i < l.size(); i++) {
			Object abc = l.get(i);
			l_age = new LinkedList<Object>();
			for (int j = 0; j < a; j++) {
				s1 = t1.get(j, 11);
				if (t1.get(j, 6).equals(abc)) {
					l_age.add(s1);
				}
			}
			Object alliance = new Object();
			if (upa.contains(abc)) {
				alliance = "UPA";
			} else if (nda.contains(abc)) {
				alliance = "NDA";
			} else if (third.contains(abc)) {
				alliance = "Third Front";	
			} else
				alliance = "Others";

			System.out.println(abc + " is in " + alliance);
		}
		System.out.print("['UPA'," + count1 + "],");
		System.out.print("['NDA'," + count2 + "],");
		System.out.print("['Third Front'," + count3 + "],");
		System.out.print("['Others'," + count4 + "],");
	}
}
