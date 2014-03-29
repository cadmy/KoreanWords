package ru.cadmy.koreanwords;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * Класс MainActivity выполняет перебор слов в случайном порядке для изучения
 * корейского языка. Существует возможность перевода слов на русский и озвучка.
 * @author Cadmy
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	
	TextView word;
	
	Button translateB;
	Button soundB;
	Button nextB;
	
	int rn1;
	boolean l;
	
	final int INFO_WINDOW = 1;
	
	SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// получаем SharedPreferences, которое работает с файлом настроек
	    sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		translateB = (Button) findViewById(R.id.translateB);
	    soundB = (Button) findViewById(R.id.soundB);
	    nextB = (Button) findViewById(R.id.nextB);
	    
		word = (TextView) findViewById(R.id.word);
		word.setTextSize(40);

		 // прописываем обработчик
		translateB.setOnClickListener(this);
		soundB.setOnClickListener(this);
		nextB.setOnClickListener(this);
		
		onClick(nextB);
	}
	
    
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mymenu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	
    public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()){	
    	case R.id.info:
    		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this); 
    		
    		dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		    public void onClick(DialogInterface dialog, int whichButton) {
    		    	
    		    }
    		});
    		
    		dlgAlert.setTitle(R.string.info_title);
    		dlgAlert.setMessage(R.string.info_message);
    		dlgAlert.setCancelable(true);
    	    dlgAlert.create().show();
    		break;
    	/*case R.id.settings:
    		Intent intent = new Intent(this, PrefActivity.class);
	        startActivity(intent);
	        break;*/
    	}
        return super.onOptionsItemSelected(item);
    }
    
	public void onClick(View v) {
		switch (v.getId()) {
	    case R.id.translateB:
			if (l==false) {
				word.setText(RussianWords(rn1));
				l=true;
			} else {
				word.setText(KoreanWords(rn1));
				l=false;
			}
			break;
	    
	    case R.id.soundB:
	    	SoundWord(rn1);
	    	break;

		case R.id.nextB:
			//случайное слово
			
			rn1 =  (int)Math.floor(Math.random() * 101);
			word.setText(KoreanWords(rn1));
			
			/*Context context = getApplicationContext();
			CharSequence text = "Hello toast! " + word.getText();
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();*/
			
			break;
		}
	}
  
	//FIXME
	/*protected void onResume() {
		String listVolumeVoc = sp.getString("list1", "");
		//String listLangs = sp.getString("listValues", "");
		//Toast.makeText(this,listVolumeVoc, Toast.LENGTH_LONG).show();
		//onClick(nextB);
	}*/

	public static String KoreanWords(int i){
		String[] koreanVoc = new String[101];
		
		//корейский словарь
		koreanVoc[0]="거리";
		koreanVoc[1]="나무";
		koreanVoc[2]="노트";
		koreanVoc[3]="사람";
		koreanVoc[4]="다리";
		koreanVoc[5]="바다";
		koreanVoc[6]="바빠요";
		koreanVoc[7]="바지";
		koreanVoc[8]="바스";
		koreanVoc[9]="비";
		koreanVoc[10]="비디오";
		koreanVoc[11]="비싸요";
		koreanVoc[12]="시계";
		koreanVoc[13]="싸요";
		koreanVoc[14]="쓰레기";
		koreanVoc[15]="아빠";
		koreanVoc[16]="아이";
		koreanVoc[17]="야구";
		koreanVoc[18]="어머니";
		koreanVoc[19]="여자";
		koreanVoc[20]="오이";
		koreanVoc[21]="우유";
		koreanVoc[22]="이";
		koreanVoc[23]="어유";
		koreanVoc[24]="카메라";
		koreanVoc[25]="가르치다";
		koreanVoc[26]="가리키다";
		koreanVoc[27]="가치";
		koreanVoc[28]="고추";
		koreanVoc[29]="고프다";
		koreanVoc[30]="교수";
		koreanVoc[31]="구타";
		koreanVoc[32]="구토";
		koreanVoc[33]="구치소";
		koreanVoc[34]="구하다";
		koreanVoc[35]="기타";
		koreanVoc[36]="기차";
		koreanVoc[37]="기차표";
		koreanVoc[38]="기체";
		koreanVoc[39]="기초";
		koreanVoc[40]="기호";
		koreanVoc[41]="나타나다";
		koreanVoc[42]="노예";
		koreanVoc[43]="노크";
		koreanVoc[44]="노처녀";
		koreanVoc[45]="니트";
		koreanVoc[46]="대여";
		koreanVoc[47]="도토리";
		koreanVoc[48]="도표";
		koreanVoc[49]="마치다";
		koreanVoc[50]="며느리";
		koreanVoc[51]="모피";
		koreanVoc[52]="묘지";
		koreanVoc[53]="미치다";
		koreanVoc[54]="바코드";
		koreanVoc[55]="배터리";
		koreanVoc[56]="배추";
		koreanVoc[57]="벼";
		koreanVoc[58]="부케";
		koreanVoc[59]="보드카";
		koreanVoc[60]="보호하다";
		koreanVoc[61]="비키니";
		koreanVoc[62]="사투리";
		koreanVoc[63]="사치";
		koreanVoc[64]="사표";
		koreanVoc[65]="서해";
		koreanVoc[66]="세차";
		koreanVoc[67]="수표";
		koreanVoc[68]="소파";
		koreanVoc[69]="시차";
		koreanVoc[70]="시키다";
		koreanVoc[71]="아파트";
		koreanVoc[72]="아프다";
		koreanVoc[73]="오해";
		koreanVoc[74]="야하다";
		koreanVoc[75]="얘기";
		koreanVoc[76]="여보";
		koreanVoc[77]="요구르트";
		koreanVoc[78]="예";
		koreanVoc[79]="예고";
		koreanVoc[80]="오토바이";
		koreanVoc[81]="지하";
		koreanVoc[82]="지폐";
		koreanVoc[83]="지혜";
		koreanVoc[84]="초대하다";
		koreanVoc[85]="카드";
		koreanVoc[86]="커피";
		koreanVoc[87]="코";
		koreanVoc[88]="키스";
		koreanVoc[89]="쿠키";
		koreanVoc[90]="키";
		koreanVoc[91]="타이어";
		koreanVoc[92]="토마토";
		koreanVoc[93]="포도";
		koreanVoc[94]="피부";
		koreanVoc[95]="하다";
		koreanVoc[96]="허리";
		koreanVoc[97]="휴가";
		koreanVoc[98]="휴지";
		koreanVoc[99]="길";
		koreanVoc[100]="말";
		
	  	return koreanVoc[i];
	}
	
	
	public static String RussianWords(int i){
		String[] russianVoc = new String[101];
		
		//русский словарь
		russianVoc[0]="улица";
		russianVoc[1]="дерево";
		russianVoc[2]="тетрадь";
		russianVoc[3]="человек";
		russianVoc[4]="мост";
		russianVoc[5]="море";
		russianVoc[6]="быть занятым";
		russianVoc[7]="брюки";
		russianVoc[8]="автобус";
		russianVoc[9]="дождь";
		russianVoc[10]="видео";
		russianVoc[11]="дорогой (цена)";
		russianVoc[12]="часы";
		russianVoc[13]="дешевый (цена)";
		russianVoc[14]="мусор";
		russianVoc[15]="папа";
		russianVoc[16]="малыш, ребенок";
		russianVoc[17]="бейсбол";
		russianVoc[18]="мать";
		russianVoc[19]="женщина";
		russianVoc[20]="огурец";
		russianVoc[21]="молоко";
		russianVoc[22]="этот";
		russianVoc[23]="причина";
		russianVoc[24]="камера";
		russianVoc[25]="учить";
		russianVoc[26]="указывать";
		russianVoc[27]="стоимость";
		russianVoc[28]="острый перец";
		russianVoc[29]="быть голодным";
		russianVoc[30]="профессор";
		russianVoc[31]="бить";
		russianVoc[32]="рвота";
		russianVoc[33]="тюрьма";
		russianVoc[34]="сохранять";
		russianVoc[35]="гитара";
		russianVoc[36]="поезд";
		russianVoc[37]="ж/д билет";
		russianVoc[38]="газ";
		russianVoc[39]="основа";
		russianVoc[40]="символ";
		russianVoc[41]="появляться";
		russianVoc[42]="раб";
		russianVoc[43]="удар";
		russianVoc[44]="старая дева";
		russianVoc[45]="трикотаж";
		russianVoc[46]="долг";
		russianVoc[47]="желудь";
		russianVoc[48]="схема";
		russianVoc[49]="заканчивать";
		russianVoc[50]="падчерица";
		russianVoc[51]="мех";
		russianVoc[52]="кладбище";
		russianVoc[53]="сумасшедший";
		russianVoc[54]="штрих-код";
		russianVoc[55]="батарея";
		russianVoc[56]="китайская капуста";
		russianVoc[57]="рисовое поле";
		russianVoc[58]="букет";
		russianVoc[59]="водка";
		russianVoc[60]="защищать";
		russianVoc[61]="бикини";
		russianVoc[62]="диалект";
		russianVoc[63]="роскошь";
		russianVoc[64]="отставка";
		russianVoc[65]="запад";
		russianVoc[66]="автомойка";
		russianVoc[67]="проверка";
		russianVoc[68]="софа";
		russianVoc[69]="разница во времени";
		russianVoc[70]="заказывать";
		russianVoc[71]="квартира";
		russianVoc[72]="боль";
		russianVoc[73]="недоразумение";
		russianVoc[74]="громкий";
		russianVoc[75]="история";
		russianVoc[76]="милый";
		russianVoc[77]="йогурт";
		russianVoc[78]="пример";
		russianVoc[79]="уведомление";
		russianVoc[80]="мотоцикл";
		russianVoc[81]="метро";
		russianVoc[82]="банкнота";
		russianVoc[83]="мудрость";
		russianVoc[84]="приглашать";
		russianVoc[85]="карточка";
		russianVoc[86]="кофе";
		russianVoc[87]="нос";
		russianVoc[88]="поцелуй";
		russianVoc[89]="нос";
		russianVoc[90]="рост";
		russianVoc[91]="шины";
		russianVoc[92]="помидор";
		russianVoc[93]="виноград";
		russianVoc[94]="кожа";
		russianVoc[95]="делать";
		russianVoc[96]="талия";
		russianVoc[97]="выходной";
		russianVoc[98]="туалетная бумага";
		russianVoc[99]="дорога";
		russianVoc[100]="лошадь";
	  	
		return russianVoc[i];
	}
	
	/*метод, осуществляюший озвучку слов*/
	public void SoundWord(int i){
		MediaPlayer mp0 = MediaPlayer.create(MainActivity.this, R.raw.street);
		MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.tree);
		MediaPlayer mp2 = MediaPlayer.create(MainActivity.this, R.raw.note);
		MediaPlayer mp3 = MediaPlayer.create(MainActivity.this, R.raw.sister);
		MediaPlayer mp4 = MediaPlayer.create(MainActivity.this, R.raw.bridge);
			
		switch (i) {
		case 0:
		    mp0.start();
		    break;
		    
		case 1:
			mp1.start();
		    break;
		    
		case 2:
		    mp2.start();
		    break;
			
		case 3:
		     mp3.start();
		     break;
		    
		case 4:
		     mp4.start();
		     break;
		}
	}
	
}
