package gr.aueb.dmst.StopSpread;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/** A class where the user can read stories of patients and/or
 * write and send his own story*/
public class Stories {
	/** The main method of the class
	 * Prints user's menu
	 * User reads or/and creates his own story
	 * Exits when user types "3"
	 * */
	public static void stories() {

		ArrayList<String> list  = new ArrayList<String>();
		Menus menu = new Menus();
		boolean contloop = true;
		Scanner sc1 = new Scanner(System.in);
			while (true) {
				do {
					/** The try block contains the code that it is likely
					 * to lead to mistakes*/
					try {
						menu.storiesMenu();
						int ch = sc1.nextInt();
						if (ch == 1) {
							menu.readStories();
							Scanner sc = new Scanner(System.in);
							int ans = sc.nextInt();
							while (true) {

								if (ans == 1) {
									System.out.println(" Νότια Αμερική, Λος ’ντζελες, Παρίσι, Κολωνία,"
										+ " Λίβερπουλ, ’μπου Ντάμπι και η ζωή από τον πρώτο "
										+ "συναγερμό για τον SARS-CoV-2 μέχρι τη σημερινή "
										+ "πραγματικότητα. Αυτή θα μπορούσε να είναι η \"λεζάντα\""
										+ " των εικόνων που μεταφέρουν στο ΑΠΕ-ΜΠΕ Έλληνες που είτε"
										+ " μένουν και εργάζονται στις τέσσερις γωνιές του πλανήτη "
										+ "είτε βρέθηκαν για αναψυχή στο εξωτερικό, όταν ξέσπασε η"
										+ " πανδημία.\r\n" + "Η Κάλλη Ρουμελιώτου μόλις επέστρεψε "
										+ "στην Ελλάδα, αφήνοντας πίσω της τη \"γνωριμία\""
										+ " με λαούς και χώρες που είχε σχεδιάσει να"
										+ " επισκεφθεί σε ένα ταξίδι εμπειριών, που μετατράπηκε, "
										+ "όμως, σε ημερολόγιο \"απόδρασης\" με κατεπείγουσες"
										+ " διαδικασίες.\r\n Ο Σταύρος Βασιλειάδης περιγράφει ένα"
										+ " Λος ’ντζελες που δεν έχει καμία σχέση με την πόλη,"
										+ " στην οποία έχει ζήσει τα τελευταία χρόνια. Εξηγεί πώς"
										+ " μια αμερικανική πολιτεία με το ΑΕΠ της Γαλλίας έχει "
										+ "κόσμο που -για πρώτη φορά- περπατάει αντί να οδηγεί,"
										+ " \"αδειάζει\" τις λεωφόρους των δέκα λωρίδων και..."
										+ " αποθηκεύει τρόφιμα και χαρτιά υγείας.\r\n"
										+"H Κική Καρύδου μιλάει για τις Βρυξέλλες, την \"καρδιά\" "
										+ "της Ευρώπης και των κέντρων αποφάσεων, όπου για πρώτη "
										+ "φορά εδώ και χρόνια τα γραφεία είναι άδεια, "
										+ "στα εστιατόρια δεν γίνονται συναντήσεις και στα "
										+ "κομμωτήρια εισέρχεται ένας πελάτης τη φορά, "
										+ "ενώ οι Βέλγοι φεύγουν από τα σούπερ μάρκετ με τα "
										+ "απαραίτητα και μερικές ...μπύρες στο καλάθι.\r\n"
										+"Η Στεφανία Τσακιράκη, ασκούμενη εικαστική θεραπεύτρια,"
										+ " μεταφέρει την εικόνα ενός Παρισιού που δεν \"λάμπει\","
										+ " ενός λαού που \"συμφιλιώθηκε γρήγορα με το καθεστώς "
										+ "\"καραντίνα\"\" κι ενός προστίμου \"που έχει "
										+ "αποτελέσματα\", ενώ ο Δημήτρης Γιαντσίδης αναγκάστηκε να"
										+ " γυρίσει με το πρώτο αεροπλάνο και όχι 13 ημέρες μετά,"
										+ " όπως ήθελε το συμβόλαιό του, από το Λος ’ντζελες όπου"
										+ " θα εργαζόταν, πίσω στη Γερμανία. Περιγράφει από την"
										+ " Κολωνία, όπου ζει με την πενταμελή του οικογένεια,"
										+ " μια Γερμανία \"χαλαρή και απείθαρχη\" μέχρι το "
										+ "διάγγελμα της Καγκελαρίου Μέρκελ και μια προσαρμογή"
										+ " ταχύτατη από εκεί και μετά.\r\n" +
										"Ο Γιάννης Νισύριος, προϊστάμενος Χημείου Βιομηχανίας, "
										+ "κάτοικος του Γουόριγκτον, 30 χιλιόμετρα από το"
										+ " Λίβερπουλ, εξηγεί πως το Ηνωμένο Βασίλειο έχει περάσει"
										+ " από πολλά, πολύ διαφορετικά στάδια προσαρμογής στη νέα"
										+ " κατάσταση, μέσα σε λίγες μόλις ημέρες, με \"μια"
										+ " μειοψηφία που τα αγνοεί όλα και συνεχίζει τη ζωή της"
										+ " κανονικά\".\r\n" +
										"Ο Σπύρος Πλακούδας, καθηγητής στο ’μπου Ντάμπι, εξηγεί"
										+ " πως σήμερα \"όσο ο φόρος αίματος στην Ευρώπη και το "
										+ "Ιράν αυξάνεται\", τόσο υιοθετούνται νέα μέτρα που"
										+ " \"οδηγούν νομοτελειακά σε γενική καραντίνα\" και στα "
										+ "Ηνωμένα Αραβικά Εμιράτα.\r\n" +
										"Ακολουθούν οι μαρτυρίες και εμπειρίες τους στην εποχή του"
										+ " Covid-19:\r\n" +
										"-Κάλλι Ρουμελιώτου, εκπαιδευτικός, ταξιδεύτρια στη Νότια"
										+ " Αμερική, Χιλή, Βολιβία, Βραζιλία:\r\n" +
										"\"Η κανονική ημερομηνία επιστροφής στην Ελλάδα -σε έναν"
										+ " μήνα περίπου- δεν θα ήταν πλέον ρεαλιστική. "
										+ "Βρεθήκαμε στη Χιλή πριν από έναν μήνα, όταν πρωτοάρχισαν"
										+ " τα κρούσματα. Αν και στο αεροδρόμιο φορούσαν μάσκες "
										+ "και μας πήραν τη θερμοκρασία, η ζωή συνεχιζόταν κανονικά"
										+ " με αγκαλιές και σταυρωτά φιλιά. Περνώντας στα χωριά "
										+ "της Βολιβίας, τα πράγματα ήταν ήρεμα μέχρι να μπούμε "
										+ "στην πόλη. Ο κόσμος παντού με μάσκες, μας σταματάει "
										+ "η αστυνομία, μας φωτογραφίζει και μας επισημαίνει ότι"
										+ " ως \"ξένοι\" οφείλουμε να φοράμε μαντήλι. "
										+ "Το hostel μας έρημο, ο ιδιοκτήτης πολύ φιλικός και"
										+ " εξυπηρετικός. Την επόμενη μέρα μας ενημερώνει ότι"
										+ " κλείνουν τα σύνορα και υπάρχει απαγόρευση κυκλοφορίας,"
										+ " μετά τις πέντε το απόγευμα, με ποινή φυλάκισης.\r\n"
										+"\"Στον δρόμο μας αποφεύγουν σαν να έχουμε ήδη τον ιό. "
										+ "Κι ενώ στη Χιλή μπορούσες να μας περάσεις και για "
										+ "ντόπιους, εδώ κάτι τέτοιο είναι αδύνατο, τόσο εξαιτίας"
										+ " της φυσικής εμφάνισης όσο και στυλιστικά. "
										+ "Από τις πέντε παρά, η αστυνομία \"πλημμυρίζει\" "
										+ "τους δρόμους. Περπατάμε ανήσυχοι και σε εγρήγορση. "
										+ "Διαβάζουμε ιστορίες ατόμων που γνωρίσαμε πριν από"
										+ " μερικές ημέρες: τους διώχνουν από τα hostels, δεν"
										+ " τους αφήνουν να αγοράσουν ή να παραγγείλουν."
										+ " Φοβούνται και η κυβέρνηση το ενισχύει... "
										+ "Το νιώθουμε στην ατμόσφαιρα. Δημιουργείται ο φόβος ότι"
										+ " αν κάτι πάθουμε τώρα, θα δυσκολευτούμε να βρούμε "
										+ "βοήθεια. Μας σταματάνε ξανά στον δρόμο, πάλι θερμόμετρο,"
										+ " πάλι φωτογραφία και ιστορικό: \"πόσο καιρό είστε εδώ,"
										+ " πού ήσασταν πριν, πότε θα φύγετε\"... Έχουμε γίνει ο"
										+ " εχθρός και αγχώνομαι μήπως δείξει το θερμόμετρο "
										+ "δέκατα καθώς μόλις κατέβηκα από το ποδήλατο.\r\n"
										+ "\"Αποφασίζουμε να φύγουμε για Βραζιλία. Στο αεροδρόμιο"
										+ " δεν μας αφήνουν να πετάξουμε, αν δεν έχουμε εισιτήριο"
										+ " που να μας επιστρέφει Ευρώπη. Χρειάζονται απόδειξη "
										+ "ότι θα φύγουμε από την ήπειρο. Προσπερνάμε κι αυτό το"
										+ " εμπόδιο και φτάνουμε στη Βραζιλία. Οι μάσκες υπάρχουν,"
										+ " μηνύματα παντού: \"ο ιός υπάρχει, αλλά αν προσέχουμε"
										+ " όλα θα πάνε καλά. Δεν υπάρχει λόγος αναστάτωσης\"."
										+ " Η εικόνα επιβεβαιώνει τα όσα είχαμε διαβάσει:"
										+ " η Βραζιλία δεν έχει πάρει ακόμη δραστικά μέτρα,"
										+ " παρακινώντας τον κόσμο να συνεχίσει να ζει κανονικά."
										+ " Στον πίνακα αναχωρήσεων, όμως, οι μισές πτήσεις"
										+ " έχουν τη σήμανση \"cancelled\". Μετά μια ακόμα"
										+ " περιπέτεια, καταφέρνουμε να πετάξουμε για Λονδίνο."
										+ " ’λλος κόσμος εδώ. Τα δικά μας συμπεράσματα: το πώς"
										+ " αντιδρονύ οι άνθρωποι σε σχέση με τον ιό, σχετίζεται"
										+ " με την επίσημη γραμμή του τόπου.\r\n"
										+ "\"Σε όλα αυτά πάντως υπάρχει και η θετική πλευρά."
										+ " Μέσα στην τρέχουσα αποξένωση, υπάρχει η διαδικτυακή "
										+ "κοινότητα των \"warmshowers\", άτομα που ανοίγουν"
										+ " τα σπίτια τους σε ταξιδιώτες ποδηλάτες προσφέροντα"
										+ "ς φιλοξενία. Στη σελίδα τους στο Facebook, πολυάριθμα"
										+ " μέλη δηλώνουν την τοποθεσία τους και τι μπορούν να"
										+ " παρέχουν σε άτομα που έχουν αποκλειστεί λόγω "
										+ "απαγορεύσεων και δεν μπορούν να επιστρέψουν- "
										+ "μετακινηθούν. Μια νότα αισιοδοξίας, αλτρουισμού "
										+ "και ανθρωπιάς, με σεβασμό στα μέτρα αυτοπροστασίας\".\r\n"
										+ "   -Σταύρος Βασιλειάδης, χημικός μηχανικός, Σαν Φρανσίσκο,"
										+ " Λος ’ντζελες, ΗΠΑ:\r\n"
										+"   \"Ζω στο κέντρο του Χόλιγουντ στο Λος ’ντζελες και"
										+ " εργάζομαι στο επονομαζόμενο \"Studio City\", που"
										+ " βρίσκεται δίπλα στα studios της Universal."
										+ " Και οι δύο περιοχές στις οποίες κινούμαι είναι "
										+ "πολυσύχναστες. Είναι γεμάτες στούντιο γυρισμάτων,"
										+ " γυμναστήρια, θεματικά πάρκα, σούπερ μάρκετ. Συνήθως"
										+ " καλύπτω, οδηγώντας, την απόσταση με μια διαδρομή 15"
										+ " με 20 λεπτών. Το σκηνικό εδώ άλλαξε κυριολεκτικά σε "
										+ "μια νύχτα. Ξαφνικά, οι δρόμοι είναι άδειοι και υπάρχει"
										+ " μια ησυχία που με ανησυχεί πιο πολύ από τον ιό. Την"
										+ " Παρασκευή έκανα 7 λεπτά για να φτάσω στο γραφείο μου,"
										+ " ήμουν σε περιφερειακό με 10 λωρίδες μόνος μου!\r\n" +
										"ν Αμερική, πιστεύουν δηλαδή στο \"τέλος του κόσμου\""
										+ " και δηλώνουν \"προετοιμασμένοι\" για αυτό.\r\n"
										+ "\"Σε αυτό που ζούμε υπάρχει και αυτό που ονομάζουν "
										+ "\"silver lining\" οι Αμερικανοί. Κάθε μέρα βγαίνω και"
										+ " περπατάω για να πάρω λίγο αέρα έξω από το κλουβί, "
										+ "το διαμέρισμα #209, όπου ζω. Στο Λος ’ντζελς, ο κόσμος"
										+ " γενικά δεν περπατάει και όλοι οδηγούν. Αυτές τις "
										+ "ημέρες, όμως, οι γειτονιές είναι γεμάτες περιπατητές."
										+ " Αρχικά θα σε αποφύγουν διακριτικά, σταματούν όμως "
										+ "δύο βήματα μετά πιο κάτω για να σε χαιρετήσουν, να "
										+ "ρωτήσουν αν είσαι καλά, αν πάνε όλα καλά με τη δουλειά"
										+ " και μετά θα συνεχίσουν το περπάτημα. Σε μια πόλη "
										+ "τόσο απρόσωπη ξαφνικά βλέπω χαμόγελα και ανθρωπιά!"
										+ " Ίσως αυτή η πανδημία να κάνει και κάποιο καλό τελικά. "
										+ "Να αγαπάτε ο ένας τον άλλον. Μόνο εμάς έχουμε!\".\r\n" +
										"-Κική Καρύδου, αξιωματούχος διαχείρισης προγραμμάτων,"
										+ " Βρυξέλλες, Βέλγιο:\r\n"
										+ "\"Πριν ανακοινωθούν τα μέτρα από την κυβέρνηση,"
										+ " όλοι συζητούσαν, ρωτούσαν τους Ιταλούς φίλους τι"
										+ " γίνεται στη χώρα τους χωρίς να επηρεάζεται η "
										+ "καθημερινότητά μας. Μετά τα μέτρα, τα οποία "
										+ "ανακοινώθηκαν και τέθηκαν σε εφαρμογή κυριολεκτικά "
										+ "σε μια μέρα, αρχίσαμε να ανησυχούμε, με αποτέλεσμα"
										+ " να αδειάσουμε τα σούπερ μάρκετ. Τις τελευταίες ημέρες"
										+ ", στα περισσότερα μάρκετ είχε και έχει ουρές, κάτι που"
										+ " οφείλεται και στο ότι επιτρέπεται περιορισμένος αριθμός"
										+ " ατόμων σε κάθε χώρο, ενώ επιτρέπεται να μένεις μέσα 15"
										+ " λεπτά. Ανοιχτά είναι και καταστήματα βιολογικών "
										+ "προϊόντων, όπως και οι φούρνοι. Είναι πάντως "
										+ "χαρακτηριστικό πως αποφασίστηκε να παραμείνουν "
										+ "ανοιχτά τα κομμωτήρια, όπως έγινε και στη Γερμανία,"
										+ " αν και επιτρέπεται ένα άτομο τη φορά μέσα. "
										+ "Μέσα στην εβδομάδα ηρέμησε η κατάσταση. Είναι \"strongly"
										+ " recommended\" να πάμε στα πάρκα για φυσική άσκηση"
										+ " άλλα μόνο δύο άτομα από το ίδιο σπίτι ή δύο φίλοι,"
										+ " κρατώντας αποστάσεις. Οι άνθρωποι τρέχουν σε "
										+ "πεζοδρόμια και πάρκα, χειροκροτούν από τα μπαλκόνια"
										+ " και δουλεύουν από το σπίτι, περιμένοντας την "
										+ "επιστροφή στην \"κανονικότητα\". Βοηθά πάντως και"
										+ " ο καιρός, αφού μας το γύρισε σε χειμώνα και για"
										+ " μερικές ημέρες είχε βροχή και πολύ κρύο\".\r\n"
										+ "-Στεφανία Τσακιράκη, ασκούμενη εικαστική θεραπεύτρια,"
										+ " Παρίσι, Γαλλία:\r\n"
										+ " \"Η Γαλλία μπήκε απότομα και συμφιλιώθηκε γρήγορα "
										+ "με το καθεστώς καραντίνας. Πλέον για να βγεις από "
										+ "το σπίτι χρειάζεται υπεύθυνη δήλωση -ανέκαθεν λάτρεις"
										+ " της γραφειοκρατίας οι Γάλλοι- με πρόστιμο στους μη "
										+ "τηρούντες τον νόμο. Παρότι αστείο στην αρχή, βοήθησε"
										+ " πολύ ως μέτρο στο να μείνουμε σπίτι μας. Η Γαλλία -"
										+ "κάτι το οποίο ξέρει όποιος την έχει επισκεφτεί στο "
										+ "παρελθόν- δεν είναι η ίδια σήμερα, σε τίποτα."
										+ " Η υπεύθυνη δήλωση για κυκλοφορία φάνηκε μέτρο "
										+ "ανούσιο στην αρχή, όταν όμως βλέπεις στα 200 μέτρα"
										+ " από το σπίτι σου να κόβουν πρόστιμο σε πεζό, "
										+ "καταλαβαίνεις γιατί ο κόσμος αποφάσισε να μείνει"
										+ " σπίτι επιτέλους. Το πρόστιμο αυτό σε όσους κυκλοφορούν"
										+ " χωρίς την υπεύθυνη δήλωση είχε απροσδόκητα αποτελέσματα"
										+ ". Ναι, οι Γάλλοι πλέον μένουν σπίτι! Οχήματα ελάχιστα"
										+ " και αναμονή για μια καλύτερη ημέρα και τη λήξη του"
										+ " συναγερμού\".\r\n" +
										"-Δημήτρης Γιαντσίδης, ειδικός τεχνολογικών συστημάτων"
										+ ", ελεύθερος επαγγελματίας, Κολωνία, Γερμανία:\r\n"
										+ "\"Μέχρι και το διάγγελμα της καγκελαρίου Μέρκελ"
										+ " στη Γερμανία ήταν σαν να μην συνέβαινε τίποτα,"
										+ " χαλαροί και απείθαρχοι οι κάτοικοι στην Κολωνία"
										+ " θα έλεγα. Όλοι στους δρόμους, κανονικά βόλτες,"
										+ " αγκαλιές, ποτό, καφές, φαγητό... Οι δρόμοι γεμάτοι"
										+ " και οι εκδηλώσεις κανονικά, σαν να μην συμβαίνει"
										+ " τίποτα. Οι Γερμανοί είχαν πάρει αψήφιστα ό,τι άκουγαν."
										+ " Μέσα σε μια- δύο ημέρες όλα άλλαξαν. Είχα βρεθεί σε "
										+ "μεγάλο κατάστημα με είδη σπιτιού μια ημέρα πριν από την"
										+ " ομιλία της κ. Μέρκελ και δεν υπήρχαν και πολλά μέτρα"
										+ " προστασίας, την επομένη είχαν τοποθετηθεί ειδικά "
										+ "προστατευτικά για τα ταμεία, παντού υπήρχαν μέσα "
										+ "προστασίας. Και στη Γερμανία είχε και έχει ουρές"
										+ " στα σούπερ μάρκετ. Υπάρχουν πάντως και πολλοί που"
										+ " ακόμη δεν έχουν πάρει στα σοβαρά τις απαγορεύσεις. "
										+ "Έβλεπες κάποιες φορές, έξω ακόμη και οικογένειες να"
										+ " κυκλοφορούν, αν και αυτό αλλάζει όσο περνούν οι ημέρες."
										+ " Τα εργοστάσια σταματούν την παραγωγή τους, ελεύθεροι"
										+ " επαγγελματίες, όπως εγώ, ανησυχούν και περιμένουν "
										+ "μέτρα στήριξης. αφού αλλιώς υπάρχει κίνδυνος οικονομικής"
										+ " καταστροφής τους. Έχουμε χάσει όλες τις δουλειές"
										+ " μας για το επόμενο διάστημα καθώς τα πάντα ακυρώθηκαν."
										+ "\r\n"
										+ "-Γιάννης Νισύριος, προϊστάμενος Χημείου Βιομηχανίας,"
										+ " Γουόριγκτον, 30 χλμ από το Λίβερπουλ, Ηνωμένο Βασίλειο:"
										+ "\r\n"
										+ "\"Υπάρχει τεράστιο πρόβλημα με τους πανικόβλητους"
										+ " αγοραστές, οι οποίοι αδειάζουν καθημερινά τα ράφια "
										+ "των σουπερ μάρκετ από χαρτί υγείας, μακαρόνια, ρύζι"
										+ " και κονσέρβες. Ο κόσμος ανησυχεί, η κυβέρνηση τώρα "
										+ "μόλις άρχισε τις απαγορεύσεις και οι περισσότεροι"
										+ " περιμένουν τα χειρότερα σύντομα. ’λλοι φυσικά "
										+ "συνεχίζουν τη ζωή τους κανονικά. Όπως και στην "
										+ "Ελλάδα, υπάρχει μια πλειοψηφία που εμπιστεύεται τον"
										+ " βρετανικό ΕΟΔΥ και υπακούει \"μουδιασμένα\" στις "
										+ "εκκλήσεις της κυβέρνησης, αλλά και μια μειοψηφία που"
										+ " τα αγνοεί όλα και συνεχίζει τη ζωή της κανονικά."
										+ " Μέσα Μαζικής Μεταφοράς, εμπορικά κέντρα και πεζόδρομοι"
										+ " είναι άδεια, ενώ τα σουπερ μάρκετ έχουν κόσμο, αλλά "
										+ "πολύ λιγότερο από την προηγούμενη εβδομάδα, εκτός από"
										+ " τις πρώτες ώρες, μετά το άνοιγμα, που τρέχουν οι πιο "
										+ "πανικόβλητοι για να βρουν τις προμήθειες που τους "
										+ "λείπουν. Είναι πάντως κάπως περίεργο για εμάς τους "
										+ "Έλληνες το ότι ακούσαμε από τον πρωθυπουργό πως οι "
										+ "απαγορεύσεις είναι ενάντια \"στο δικαίωμα όσων έχουν"
										+ " γεννηθεί στην Αγγλία να πάνε στην πάμπ\"\"...\r\n"
										+ "-Σπύρος Πλακούδας, καθηγητής, Αμπού Ντάμπι, Ηνωμένα "
										+ "Αραβικά Εμιράτα:\r\n"
										+ "\"Η οδηγία για το κλείσιμο των σχολείων και των "
										+ "πανεπιστημίων στα τέλη Φεβρουαρίου ήρθε σαν κεραυνός "
										+ "εν αιθρία, όταν υπήρχαν ελάχιστα ακόμη κρούσματα."
										+ " Όσο ο φόρος αίματος στην Ευρώπη και το Ιράν αυξάνεται,"
										+ " τόσο υιοθετούνται νέα μέτρα, που οδηγούν νομοτελειακά"
										+ " σε γενική καραντίνα. Το μεγαλύτερο εμπορικό της υφηλίου"
										+ " έχει σχεδόν αδειάσει, όπως και το πιο πολυσύχναστο"
										+ " αεροδρόμιο του κόσμου. Η καταρρακτώδης βροχή άδειασε"
										+ " και τους ήδη ημι-έρημους δρόμους. Λίγες ώρες "
										+ "μετά την έκκληση της κυβέρνησης για την αποφυγή των"
										+ " άσκοπων εξόδων, το Αμπού Ντάμπι μοιάζει να "
										+ "\"νεκρώνει\", όπως το καλοκαίρι, λόγω των υψηλών "
										+ "θερμοκρασιών. ’δειες πισίνες, άδεια γήπεδα, άδειες"
										+ " καφετέριες παντού. Η καταρρακτώδης βροχή των "
										+ "προηγούμενων 48 ωρών ήταν το τελειωτικό \"χτύπημα\""
										+ " σε μια χώρα που σιγά σιγά απομονώνεται από τον"
										+ " έξω κόσμο λόγω της πανδημίας\".\r\n" );
												}
												else if (ans == 2) {
													System.out.println("Κάποιοι παρουσίασαν ήπια συμπτώματα, "
										+ "άλλοι βαριές πνευμονίες. Όλοι, μιλώντας στη "
										+ "«ΜτΚ» για την περιπέτειά τους, στέλνουν το μήνυμα:"
										+ " «κανείς δεν είναι άτρωτος»\r\n" +
										"Βαγγέλης Στολάκης\r\n" +
										"’νδρας από τη Θεσσαλονίκη, 56 ετών, χωρίς υποκείμενα"
										+ " νοσήματα, που έχαιρε άκρας υγείας νοσηλεύτηκε με"
										+ " κορονοϊό στο νοσοκομείο αναφοράς της Θεσσαλονίκης,"
										+ " το «ΑΧΕΠΑ» στις 21 Μαρτίου. Ήταν από τα πρώτα θετικά"
										+ " κρούσματα στη χώρα μας. Σήμερα, σχεδόν πέντε μήνες "
										+ "μετά ταλαιπωρείται, καθώς μέχρι τις αρχές Αυγούστου"
										+ " νοσηλευόταν σε κλινική αποκατάστασης της πόλης. Ο "
										+ "ασθενής ήταν από τα βαριά περιστατικά του COVID-19 με"
										+ " τον ιό να του προκαλεί μέχρι και εγκεφαλική αιμορραγία,"
										+ " ενώ παρέμεινε για πολλές εβδομάδες διασωληνωμένος σε"
										+ " Μονάδα Εντατικής Θεραπείας. \r\n" +
										"«Ο ιός είναι εδώ. Πρέπει να τηρούμε τα μέτρα, να φοράμε"
										+ " όλοι μάσκα, να διατηρούμε τις μεταξύ μας αποστάσεις."
										+ " Προσβάλει όλο και νεότερους ανθρώπους. Προσωπικά,"
										+ " πίστεψα ότι δεν θα δω ξανά τους δικούς μου» αναφέρει"
										+ " στη «ΜτΚ» Θεσσαλονικιός επιχειρηματίας που νόσησε. "
										+ "Έλληνες που βρέθηκαν θετικοί στον κορονοϊό, την ώρα που"
										+ " ο αριθμός των κρουσμάτων στη χώρα και ειδικότερα στη "
										+ "Θεσσαλονίκη και την ευρύτερη περιοχή της Κεντρικής "
										+ "Μακεδονίας, αυξάνεται καταθέτουν την προσωπική τους "
										+ "μαρτυρία στη «ΜτΚ» στέλνοντας το μήνυμα: «Κανείς δεν "
										+ "είναι άτρωτος».\r\n" +
										"Ο Σπύρος Μάμαλης είναι πρόεδρος του Γεωτεχνικού "
										+ "Επιμελητηρίου Ελλάδας, 48 ετών και κατοικεί στις "
										+ "Σέρρες. Διαγνώστηκε θετικός στον κορονοϊό στις 16 "
										+ "Μαρτίου και μέχρι την 7η Απριλίου παρέμεινε στο "
										+ "«ΑΧΕΠΑ». Μόλις ξεπέρασε την περιπέτειά του, την έκανε"
										+ " γνωστή με μοναδικό σκοπό να προειδοποιήσει και να"
										+ " προστατεύσει το κοινωνικό σύνολο. \r\n" +
										"«Κόλλησα κορονοϊό στην Αμερική, όπου βρέθηκα το διάστημα "
										+ "8-13 Μαρτίου και παραχώρησα συνέντευξη Τύπου για την "
										+ "προώθηση της ελληνικής φέτας. Εκεί ήρθα σε επαφή με "
										+ "περίπου 70 άτομα. Με την επιστροφή μου στην Ελλάδα "
										+ "εκδήλωσα και τα πρώτα συμπτώματα. Μετά από τρεις μέρες"
										+ " ανέβασα υψηλό πυρετό και είχα έντονο βήχα. Τέσσερις "
										+ "μέρες αργότερα είχα έντονη δύσπνοια και τελικά μου το "
										+ "γύρισε σε πνευμονία» αναφέρει. Ο ίδιος επικοινώνησε με"
										+ " τον ΕΟΔΥ και τέθηκε για κάποιες ημέρες σε κατ οίκον "
										+ "περιορισμό. Στην αρχή μετέβη στο νοσοκομείο των Σερρών,"
										+ " όπου και διαγνώστηκε θετικός στον κορονοϊό και στη "
										+ "συνέχεια μεταφέρθηκε στο «ΑΧΕΠΑ», όπου παρέμεινε για 19"
										+ " ολόκληρες ημέρες. Ο ίδιος δεν εισήχθη σε ΜΕΘ. Όταν η"
										+ " ασθένεια αντιμετωπίστηκε τέθηκε εκ νέου σε κατ οίκον "
										+ "περιορισμό. «Σχεδόν για δυο ολόκληρους μήνες έμεινα στο"
										+ " σπίτι, ενώ κάνω συνεχώς εξετάσεις. Μέχρι σήμερα έχω "
										+ "πραγματοποιήσει τρεις εξετάσεις και τον Σεπτέμβριο"
										+ " προγραμμάτισα τέταρτη. Τα λευκά μου αιμοσφαίρια είναι"
										+ " ακόμα χαμηλά. Δεν έχω αντιμετωπίσει το πρόβλημα» "
										+ "υποστηρίζει ο κ. Μάμαλης και συμπληρώνει πως γνωρίζει"
										+ " και άλλους πρώην ασθενείς που έχουν προβλήματα και"
										+ " μετά την ασθένεια. «Θέλει προσοχή και πιστή τήρηση των"
										+ " μέτρων. Είναι δύσκολος ιός» αναφέρει ο κ. Μάμαλης.\r\n"
										+ "Μαζί του, στο δωμάτιο του νοσοκομείου, βρισκόταν ένας "
										+ "ακόμα ασθενής, 44 ετών ο οποίος, σύμφωνα με τον κ. "
										+ "Μάμαλη νοσηλεύτηκε για μεγαλύτερο χρονικό διάστημα. "
										+ "«Κινδύνευσε. Είχε πιο βαριά πνευμονία. Από όσα μου "
										+ "είπε ήταν ορφανό κρούσμα. Κόλλησε σε μία κοινωνική "
										+ "εκδήλωση που είχε πάει με τη σύζυγό του» λέει ο κ. "
										+ "Μάμαλης. Όπως περιγράφει στο διπλανό δωμάτιο του "
										+ "«ΑΧΕΠΑ» νοσηλεύτηκε για διάστημα 27 ολόκληρων ημερών"
										+ " ο 74χρονος πατέρας του, τον οποίο κόλλησε κορονοϊό"
										+ " ο ίδιος ο κ. Μάμαλης όταν εκείνος πήγε να τον βοηθήσει"
										+ " για να πάει στο νοσοκομείο. «Ο πατέρας μου νοσηλεύτηκε"
										+ " με πνευμονία και του δημιουργήθηκαν προβλήματα στο "
										+ "νευρικό σύστημα. Κατάφερε και σώθηκε χάρη στους "
										+ "εξαιρετικούς γιατρούς, τους οποίους ευχαριστούμε» "
										+ "σχολιάζει ο κ. Μάμαλης.\r\n" +
										"Από εκείνο το ταξίδι στην Αμερική, κορονοϊό κόλλησαν"
										+ " ακόμα δύο συνεργάτες του προέδρου του Γεωτεχνολογικού"
										+ " Επιμελητηρίου Ελλάδας. Μία 35χρονη αναγκάστηκε να"
										+ " νοσηλευτεί για πολλούς μήνες σε νοσοκομείο των ΗΠΑ "
										+ "και ένας ακόμα 48χρονος που διαγνώστηκε θετικός στις"
										+ " αρχές Μαρτίου ακόμα και σήμερα «κουράζεται όταν "
										+ "ανεβαίνει σκάλες».\r\n" +
										"Πώς ο ιός τον έστειλε σε κλινική αποκατάστασης\r\n" +
										"Από την εμφάνιση του πρώτου κρούσματος κορονοϊού στην"
										+ " Ελλάδα, ο πρόεδρος του Πανελληνίου Ιατρικού Συλλόγου,"
										+ " Αθανάσιος Εξαδάκτυλος σχεδόν καθημερινά μέσα από τις"
										+ " δημόσιες εμφανίσεις του καλεί τον κόσμο να τηρεί τα"
										+ " μέτρα που έχουν θεσπιστεί. «Συχνό πλύσιμο χεριών,"
										+ " μάσκες, αποστάσεις. Αυτό δεν πρέπει να το ξεχνάμε»"
										+ " σχολιάζει στη «ΜτΚ». Μάλιστα, αναφέρεται στην "
										+ "περιπέτεια ενός φίλου του που νόσησε με COVID-19."
										+ " «Πρόκειται για έναν συνάδελφο γιατρό ο οποίος στις"
										+ " 21 Μαρτίου πήγαινε στο ιατρείο του. Ένιωσε κάποια"
										+ " συμπτώματα, ενώ είχε έντονη δύσπνοια. Εισήλθε στο"
										+ " ΑΧΕΠΑ και διασωληνώθηκε σε Μονάδα Εντατικής"
										+ " Θεραπείας. Η δύσπνοια γύρισε σε πνευμονία, "
										+ "επηρεάστηκε στη συνέχεια το κεντρικό νευρικό σύστημα"
										+ " και κατέληξε με εγκεφαλική αιμορραγία. Έμεινε για"
										+ " μεγάλο διάστημα στην Νευρολογική Κλινική και μέχρι"
										+ " τις αρχές Αυγούστου βρισκόταν ακόμα σε κλινική"
										+ " αποκατάστασης» αναφέρει χαρακτηριστικά ο κ. "
										+ "Εξαδάκτυλος.\r\n" +
										"Το πρώτο κρούσμα στην Ελλάδα\r\n" +
										"Η Δήμητρα Βουλγαρίδου, είναι η 38χρονη επιχειρηματίας"
										+ " από τη Θεσσαλονίκη, το «κρούσμα μηδέν», δηλαδή η πρώτη"
										+ " ασθενής που διαγνώσθηκε με κορονοϊό στη χώρα. Μαζί "
										+ "της νόσησε και ο εννιάχρονος γιος της, ο οποίος όπως "
										+ "λέει ήταν ασυμπτωματικός. «Τα συμπτώματα μου ήταν "
										+ "σχετικά ήπια, είχα έντονο πονοκέφαλο, δέκατα και έλλειψη"
										+ " γεύσης και όσφρησης» αναφέρει στη «ΜτΚ» η κ. "
										+ "Βουλγαρίδου. «Το παιδί ευτυχώς ήταν ασυμπτωματικό» "
										+ "συμπληρώνει. Όπως εξηγεί πέραν του πονοκεφάλου που "
										+ "είχε την πρώτη ημέρα, τις υπόλοιπες ημέρες της νοσηλείας"
										+ " της δεν είχε κάτι. Μιλώντας για τη δική της περιπέτεια,"
										+ " η κ. Βουλγαρίδου σχολιάζει: «Επειδή είχα επιστρέψει από"
										+ " ένα επαγγελματικό ταξίδι που ήμουν στην Ιταλία όταν "
										+ "εμφάνισα τα πρώτα συμπτώματα πήρα τηλέφωνο στην ιδιωτική"
										+ " μου ασφάλεια υγείας, αυτοί μου έδωσαν οδηγίες και μου"
										+ " εξήγησαν πως επειδή έχω έρθει από το Μιλάνο έπρεπε να"
										+ " πάω στο κέντρο αναφοράς της πόλης μου. Έτσι και έκανα,"
										+ " πήγα απευθείας στο «ΑΧΕΠΑ».\r\n" +
										" Το πρώτο συναίσθημα που με κυρίευσε όταν μου είπαν ότι"
										+ " είμαι ο πρώτος επιβεβαιωμένος ασθενής του COVID-19 στην"
										+ " Ελλάδα ήταν ο φόβος. Σκεφτόμουν την υγεία μου, τις "
										+ "συνέπειες προς το γιο μου, τους κοντινούς μου ανθρώπους"
										+ " αλλά και όσους ήρθα σε επαφή. Αυτές οι σκέψεις με "
										+ "γονάτιζαν, μου δημιούργησαν άγχος, ενοχικότητα και "
										+ "ευθύνη. Ξεσπούσα συχνά σε λυγμούς από την αγωνία μου"
										+ " για το τι μέλλει γενέσθαι για τους γύρω μου. Ποτέ δεν"
										+ " φανταζόμουν πως σε εμένα θα συνέβαινε αυτό. Μη "
										+ "γνωρίζοντας τη πραγματικότητα του ιού και τις συνέπειες"
										+ " του, αισθανόμουν πως περπατούσα σε μία έρημο χωρίς "
										+ "κατεύθυνση» υποστηρίζει η νεαρή επιχειρηματίας μόδας."
										+ " Μιλώντας για τα συμπτώματα που εμφάνισε, αναφέρει πως"
										+ " δεν ήταν έντονα, επομένως δεν χρειάστηκε να ακολουθήσει"
										+ " κάποια συγκεκριμένη θεραπεία. «Δυστυχώς, πλέον γνωρίζω"
										+ " αρκετά άτομα που νόσησαν με τον COVID-19, οι "
										+ "περισσότεροι ευτυχώς με ήπια συμπτώματα. Υπήρξαν "
										+ "όμως και κάποιοι που χρειάστηκε να νοσηλευτούν»"
										+ " λέει.\r\n" +
										"Η κ. Βουλγαρίδου νοσηλεύτηκε σε θάλαμο αρνητικής "
										+ "πίεσης του «ΑΧΕΠΑ» για 15 ημέρες. \r\n" +
										"«Η παραμονή στο θάλαμο αρνητικής πίεσης, κράτησε "
										+ "συνολικά 15 μέρες. Δεν έχω εικόνες από άλλους "
										+ "ασθενείς γιατί ήταν αρχή ακόμη και τα περιστατικά "
										+ "δεν ήταν πολλά. Στο θάλαμο ήμουν μαζί με τον 9 χρόνο "
										+ "γιο μου. Η αγωνία ήταν για όλους μεγάλη γιατί κανείς"
										+ " δεν γνώριζε την εξέλιξη του ιού. Ό,τι γνώριζαν ήταν"
										+ " όλα από βιβλιογραφίες άλλων κρατών. Επομένως όλα "
										+ "ξεκίνησαν για όλους από το μηδέν. Παρά το ότι είχα"
										+ " ήπια συμπτώματα η αγωνία μου για την εξέλιξη της "
										+ "υγείας μου ήταν μεγάλη, όλο αυτό το άγνωστο σε συνδυασμό "
										+ "με τον εγκλεισμό μου στο θάλαμο του νοσοκομείου μαζί με"
										+ " τον γιο μου, μου δημιουργούσε άγχος και ανασφάλεια ."
										+ " Όταν μου ανακοίνωσε ο γιατρός πως μαζί μου θα"
										+ " νοσηλευτεί και το παιδί γιατί ήταν το μόνο από τις"
										+ " επαφές μου που βρέθηκε θετικό, μούδιασα. Μέσα σε λίγα"
										+ " δευτερόλεπτα σκέφτηκα πως ένα παιδί 9 χρόνων θα"
										+ " αντέξει μέσα σε ένα θάλαμο για τόσες μέρες. Το παιδί"
										+ " έπρεπε να μην καταλάβει τίποτα για το τι συμβαίνει "
										+ "και παράλληλα σκεφτόμουν και τι θα ακολουθήσει μετά"
										+ " με τις συναναστροφές του. Βλέπετε δεν κρατήθηκε "
										+ "ιατρικό απόρρητο ούτε για ένα παιδί. Όλες αυτές οι"
										+ " σκέψεις γίνανε πολύ γρήγορα. Πιέστηκα πολύ όλο το "
										+ "διάστημα. Ωραιοποιούσα το κάθετι που συνέβαινε μέσα"
										+ " στο θάλαμο, ενώ παράλληλα έπρεπε να κάνω και μία "
										+ "προετοιμασία για το μετά. Σημαντικό ρόλο έπαιξε και"
										+ " η εμψύχωση από ειδικούς του προσωπικού κύκλου μου,"
										+ " όπως και οι γιατροί αλλά και το νοσηλευτικό προσωπικό"
										+ " του ΑΧΕΠΑ για τις υπεράνθρωπες προσπάθειες που "
										+ "κατέβαλαν για μένα και το παιδί μου, με τα μέσα τα"
										+ " οποία διέθεταν» λέει η κ. Βουλγαρίδου εξιστορώντας"
										+ " στη «ΜτΚ» όλα όσα έζησε σε ένα θάλαμο νοσοκομείου"
										+ " μόλις λίγων τετραγωνικών μέτρων. Στέλνει μάλιστα"
										+ " το μήνυμα για πιστή τήρηση των μέτρων. \r\n" +
										"«Οι νέοι άνθρωποι στη χώρα μας αρχικά έδειξαν μεγάλη"
										+ " συνέπεια. Στη συνέχεια, με τη λήξη της καραντίνας"
										+ " και την μικρή χαλάρωση των μέτρων, άρχισαν να "
										+ "επιστρέφουν στην καθημερινότητα που είχαν πριν "
										+ "τον Φεβρουάριο. Θα ήθελα να πω σε όλους πως ο COVID-19"
										+ " δεν είναι ψέμα. Είναι κάτι που υπάρχει και η επιστήμη"
										+ " προσπαθεί να δώσει λύσεις αλλά φαίνεται να είναι ακόμη"
										+ " μακριά. Γι αυτό καλό είναι να είμαστε όλοι μας "
										+ "προσεκτικοί και να ακούμε όλα όσα μας λένε οι ειδικοί»"
										+ " καταλήγει η κ. Βουλγαρίδου.\r\n" +
										"Ασυμπτωματικοί ασθενείς\r\n" +
										"Ο Ν. είναι Θεσσαλονικιός επιχειρηματίας. Την περίοδο της"
										+ " καραντίνας και πιο συγκεκριμένα στις 23 Μαρτίου, "
										+ "επέστρεψε από το εξωτερικό και απευθείας από το αεροδρόμιο"
										+ " μετέβη στο εξοχικό του και τέθηκε αυτοβούλως σε κατ"
										+ " οίκον περιορισμό 14 ημερών. Δεν επέστρεψε στο σπίτι "
										+ "του στη Θεσσαλονίκη, όπου τον περίμενε η οικογένειά "
										+ "του, καθώς είχε ήπια συμπτώματα, βήχα, ήπιο τσίμπημα"
										+ " στο στήθος, και δέκατα. «Είχα ξερόβηχα για κάποιο "
										+ "διάστημα. Στο τέλος της καραντίνας έκανα τεστ και βγήκε"
										+ " αρνητικό. Λίγες ημέρες μετά έκανα τεστ αντισωμάτων "
										+ "και φάνηκε ότι έχω αντισώματα. Οι ειδικοί μου ανέφεραν"
										+ " ότι πέρασα κορονοϊό. Δεν είχα τα συμπτώματα που έχουν"
										+ " άλλοι ασθενείς» σχολιάζει στη «ΜτΚ».\r\n" +
										"Κάπως έτσι διαπίστωσε ότι νόσησε από COVID-19 και ο"
										+ " βουλευτής του Κινήματος Αλλαγής και γιατρός, Ανδρέας"
										+ " Πουλάς. «Υπήρξα ασυμπτωματικός ασθενής» λέει στη "
										+ "«ΜτΚ» ο βουλευτής Αργολίδας. «Εκτιμώ ότι κόλλησα τον"
										+ " ιό όταν επισκέφθηκα τη δομή μεταναστών στο Κρανίδι."
										+ " Δεν νόσησα. Συζητώντας με συνεργάτες μου μού είπαν"
										+ " πως μία μέρα ζήτησα ένα χάπι γιατί είχα πονοκέφαλο."
										+ " Ίσως αυτό να ήταν το μοναδικό σύμπτωμα που εκδήλωσα»"
										+ " τονίζει ο κ. Πουλάς. «Υποβλήθηκα σε δειγματοληπτικό "
										+ "τεστ στη Βουλή. Το τεστ βγήκε αρνητικό. Στη συνέχεια "
										+ "έκανα τεστ αντισωμάτων και μου είπαν πως ο οργανισμός"
										+ " μου ανέπτυξε αντισώματα για τον κορονοϊό. Δεν το "
										+ "πίστεψα. Μετά από μία εβδομάδα έκανα ξανά τεστ, το "
										+ "οποίο ήταν αρνητικό. Στη συνέχεια ξανά έκανα τεστ "
										+ "αντισωμάτων, και πάλι εμφάνισε ότι έχω αντισώματα»"
										+ " λέει ο κ. Πουλάς. «Τα μέτρα πρέπει να τηρούνται"
										+ " οπωσδήποτε. Η μεγάλη χαλαρότητα οδήγησε στις "
										+ "καταστάσεις που βιώνουμε σήμερα» καταλήγει ο"
										+ " κ. Πουλάς.\r\n" +
										"Ο βουλευτής Λάρισας, Χρήστος Κέλλας υπήρξε ένα από "
										+ "τα πρώτα κρούσματα του κορονοϊού. Όπως αφηγείται "
										+ "στη «ΜτΚ» εκδήλωσε υψηλό πυρετό για πολλές μέρες."
										+ " «Έμεινα για 15 ημέρες στο Νοσοκομείο της Λάρισας."
										+ " Μετά την όγδοη ημέρα δεν είχα κάποιο σύμπτωμα, ωστόσο"
										+ " θεωρήθηκε πως έπρεπε να μείνω μέχρι να υποβληθώ σε δυο"
										+ " τεστ και το αποτέλεσμά τους να είναι αρνητικό. Η "
										+ "ασθένεια δεν μου έχει αφήσει κάποια παρενέργεια» "
										+ "σημειώνει ο κ. Κέλλας, τονίζοντας ότι «πρέπει να "
										+ "τηρούνται τα μέτρα, να αποφεύγεται ο συγχρωτισμός,"
										+ " να κρατούν οι πολίτες αποστάσεις και να φορούν"
										+ " μάσκες». «Ο ιός υπάρχει και είναι εδώ» λέει ο βουλευτής"
										+ " της Νέας Δημοκρατίας.\r\n");
									System.out.println("Πηγή: https://www.makthes.gr/martyries-"
											+ "proin-asthenon-303858");
								}
								else if (ans == 3) {
									System.out.println("Ασθενείς που νόσησαν με covid-19, ακόμα κι "
										+ "εκείνοι που πέρασαν μάλλον ελαφρά την ασθένεια, χωρίς"
										+ " σοβαρά συμπτώματα, διαπιστώνουν πως -ακόμη και μετά"
										+ " την ανάρρωση τους- μια θολούρα στον εγκέφαλο τους "
										+ "εμποδίζει να εργαστούν κανονικά και να λειτουργήσουν"
										+ " στην καθημερινή ζωή τους.\r\n" +
										"Η κατάσταση αυτή, που θυμίζει ομίχλη του νου, "
										+ "χαρακτηρίζεται κατά περίπτωση από απώλεια μνήμης, "
										+ "σύγχυση, δυσκολία εστίασης της προσοχής, ζαλάδες"
										+ " κ.α.\r\n" +
										"«Υπάρχουν χιλιάδες άνθρωποι που έχουν κάτι τέτοιο. "
										+ "Η επίπτωση στους εργαζόμενους που έχουν επηρεαστεί,"
										+ " πρόκειται να είναι σημαντική», δήλωσε στους «New York"
										+ " Times» ο νευρολόγος-λοιμωξιολόγος δρ Ιγκόρ Κόραλνικ "
										+ "της Ιατρικής Σχολής του Πανεπιστημίου Northwestern του"
										+ " Σικάγο.\r\n" +
										"Μέχρι στιγμής οι μαγνητικές τομογραφίες και άλλες"
										+ " διαγνωστικές εξετάσεις δεν έχουν δείξει σημαντικές "
										+ "βλάβες σε εγκεφαλικές περιοχές μετά από Covid-19. Οι "
										+ "επιστήμονες δεν είναι ακόμη βέβαιοι τι προκαλεί αυτή "
										+ "την εγκεφαλική ομίχλη μετά τον Covid-19, καθώς η "
										+ "κατάσταση ποικίλει πολύ από άνθρωπο σε άνθρωπο, χωρίς"
										+ " να αφήνει αλώβητους ακόμη και ανθρώπους που πέρασαν "
										+ "ήπια τη νόσο και δεν είχαν άλλα υποκείμενα νοσήματα, "
										+ "όπως εξηγεί το ΑΜΠΕ.\r\n" +
										"Οι δύο πιθανότερες εξηγήσεις, σύμφωνα με τους νευρολόγους"
										+ ", είναι ότι η ομίχλη εμφανίζεται είτε όταν η "
										+ "ανοσοποιητική αντίδραση του σώματος έναντι του κορονοϊού"
										+ " δεν παύει αλλά συνεχίζεται επί μακρόν, είτε όταν η "
										+ "φλεγμονή στα αιμοφόρα αγγεία που προκαλεί ο ιός, τελικά"
										+ " φτάνει και στον εγκέφαλο. Δεν αποκλείεται να παίζουν "
										+ "ρόλο και μικρά εγκεφαλικά ή αυτοάνοσες αντιδράσεις, "
										+ "δηλαδή «αντισώματα που λανθασμένα επιτίθενται στα νευρικά"
										+ " κύτταρα», σύμφωνα με τη δρα Σιρίνα Σπάντιχ της Ιατρικής"
										+ " Σχολής του Πανεπιστημίου Γιέηλ.\r\n" +
										"Σύγχυση, παραλήρημα και εγκεφαλοπάθεια\r\n" +
										"Διάφορα νευρολογικά συμπτώματα, όπως σύγχυση, παραλήρημα "
										+ "και εγκεφαλοπάθεια, εκδηλώνονται σε ασθενείς που"
										+ " νοσηλεύονται με Covid-19. Σύμφωνα με πρόσφατη έρευνα,"
										+ " οι ασθενείς αυτοί παραμένουν περισσότερο χρόνο στο "
										+ "νοσοκομείο και ειδικότερα σε ΜΕΘ, έχοντας υψηλότερο"
										+ " ποσοστό θνησιμότητας. Όμως σταδιακά γίνεται αντιληπτό"
										+ " ότι, ακόμη και μετά το εξιτήριο από το νοσοκομείο, "
										+ "τα προβλήματα -ιδίως η θολούρα στο μυαλό- μπορεί να"
										+ " παραμείνουν για καιρό. Μια γαλλική μελέτη βρήκε ότι,"
										+ " από 120 ασθενείς που νοσηλεύτηκαν λόγω κορονοϊού, το"
										+ " 34% είχαν απώλεια μνήμης και το 27% προβλήματα "
										+ "συγκέντρωσης μετά από μήνες.\r\n" +
										"Είναι χαρακτηριστική η περίπτωση μιας 31χρονης ασθενούς"
										+ " δικηγόρου, η οποία, αρκετές εβδομάδες μετά την "
										+ "ανάρρωση της από την Covid-19, δεν μπορούσε καν να"
										+ " αναγνωρίσει το αυτοκίνητο της που ήταν παρκαρισμένο"
										+ " έξω από το σπίτι της. Επιπλέον, μέσα στη σύγχυση της"
										+ ", έπλυνε το τηλεκοντρόλ μαζί με τα ρούχα στο πλυντήριο"
										+ " της και τελικά αναγκάστηκε να πάρει άδεια διαρκείας από"
										+ " τη δουλειά της.\r\n" +
										"Ένας άλλος 50χρονος Αμερικανός ασθενής ξέχασε τελείως "
										+ "οτιδήποτε σχετικά με ένα 12ήμερο ταξίδι του στο Παρίσι"
										+ " που είχε κάνει μόλις πριν λίγες εβδομάδες. Κοιτάζει"
										+ " πλέον τις φωτογραφίες από το ταξίδι εκείνο και, όπως"
										+ " λέει, «δεν θυμάμαι τίποτα απολύτως». Επιπλέον, "
										+ "δυσκολεύεται πια στις συσκέψεις της δουλειάς του "
										+ "(και όχι μόνο) να βρει τις κατάλληλες λέξεις. «Φοβάμαι"
										+ " πως ακούγομαι σαν ηλίθιος», όπως λέει.\r\n" +
										"Νιώθω σαν να έχω άνοια\r\n" +
										"Μια πολύπειρη 53χρονη νοσοκόμα, μετά την λοίμωξη Covid-19"
										+ " που πέρασε, ξέχασε τι πρέπει να κάνει στη δουλειά της"
										+ " και αναγκάζεται να ρωτά τους συναδέλφους της. «Φεύγω"
										+ " από ένα δωμάτιο της κλινικής μου και δεν μπορώ να "
										+ "θυμηθώ τι μόλις μου είπε κάποιος ασθενής. Νιώθω σαν "
										+ "να έχω άνοια. Από όσο ξέρω, δεν έχω κάνει κάποιο λάθος."
										+ " Δεν έχω σκοτώσει κανέναν ακόμη», όπως δήλωσε φοβισμένη"
										+ ".\r\n" +
										"Μια έτοιμη για δημοσίευση έρευνα σε 3.930 μέλη της ομάδας"
										+ " Survivor Corps που ανάρρωσαν από τη νόσο Covid-19, "
										+ "δείχνει ότι περισσότεροι από τους μισούς έχουν δυσκολίες"
										+ " συγκέντρωσης και εστίασης, δήλωσε η αναπληρώτρια"
										+ " καθηγήτρια Νάταλι Λάμπερτ της Ιατρικής Σχολής του"
										+ " Πανεπιστημίου της Ιντιάνα. Τουλάχιστον το ένα τρίτο"
										+ " των συμμετεχόντων δήλωσαν προβλήματα μνήμης, ζαλάδες"
										+ " ή σύγχυση.\r\n" +
										"«Νιώθω σχεδόν κατατονικός. Είναι σαν να μου έχουν κάνει"
										+ " αναισθησία», ανέφερε ένας 60χρονος, ο οποίος βιώνει "
										+ "μια συνεχή εγκεφαλική ομίχλη εδώ και μήνες που ανάρρωσε"
										+ ".\r\n" +
										"Οι νευρολόγοι συμβουλεύουν τους ανθρώπους με «ομίχλη»"
										+ " διαρκείας να δουν γιατρούς και άλλων ειδικοτήτων, κυρίως"
										+ " καρδιολόγους. Δεν γνωρίζουν πάντως πόσος χρόνος θα "
										+ "χρειαστεί να περάσει για να φύγει η νοητική θολούρα -"
										+ " και αν θα φύγει σε όλες τις περιπτώσεις.\r\n");
									System.out.println("Πηγή: newsbeast.gr ");
								}
								else if (ans == 4) {
									break;
								}
								else {
									System.out.println("Παρακαλώ εισάγετε μια από τις δυνατές επιλογές");
								}

								menu.readStories();
								ans = sc.nextInt();
							}
							System.out.println("Βοηθήστε μας να εμπλουτίσουμε τη συλλογή μας "
									+ "στέλνοντας τις δικές σας ιστορίες!");
							sc.close();
						}
						else if (ch == 2) {
							Scanner scan1 = new Scanner(System.in);
							while(true) {
								System.out.println("Πληκτρολογήστε την ιστορία σας:");
								String story = scan1.next();
								list.add(story);
								System.out.println("Σας ευχαριστούμε πολύ!");
								scan1.close();
								break;
							}
						}
						else if (ch == 3) {
							break;
						}
						else {
							System.out.println("Παρακαλώ εισάγετε μια από τις "
									+ "δυνατές επιλογές!");
						}
					}
					/** The catch block which shows probable user's mistakes
					 * during the import and gives a second chance */
					catch (InputMismatchException e) {
						sc1.nextLine();
						JOptionPane.showMessageDialog(null,"InputMismatchException. Δοκιμάστε ξανά: ");
					} catch (ArithmeticException e) {
						JOptionPane.showMessageDialog(null,"ArithmeticException. Δοκιμάστε ξανά: ");
					}
				} while (contloop);
				break;
			}
			sc1.close();
	}
}
