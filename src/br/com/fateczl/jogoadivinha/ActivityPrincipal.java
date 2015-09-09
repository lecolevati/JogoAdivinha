package br.com.fateczl.jogoadivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPrincipal extends AppCompatActivity {

	EditText etNumero;
	TextView tvTentativas;
	Button btnNovo, btnLancar;
	int numeroAdivinhar, tentativas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		etNumero = (EditText)findViewById(R.id.etNumero);
		tvTentativas = (TextView)findViewById(R.id.tvTentativas);
		btnLancar = (Button)findViewById(R.id.btnLancar);
		btnNovo = (Button)findViewById(R.id.btnNovo);
		
		numeroAdivinhar = (int)((Math.random() * 101));
		tentativas = 0;
		
		btnLancar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					int numeroJogador = Integer.parseInt(etNumero.getText().toString());
					if (numeroJogador > 0 && numeroJogador < 100){
						if (numeroJogador == numeroAdivinhar){
							tentativas++;
							tvTentativas.setText(tentativas+" Tentativas");
							Toast.makeText(getApplicationContext(), "PARABÉNS !!!" + 
									"Você acertou o número "
									+ numeroAdivinhar + " com " + tentativas +
									"tentativas", 
									Toast.LENGTH_LONG).show();
							btnLancar.setVisibility(0);
						} else {
							if (numeroJogador > numeroAdivinhar) {
								tentativas++;
								tvTentativas.setText(tentativas+" Tentativas");
								Toast.makeText(getApplicationContext(),
										"O número é menor",
										Toast.LENGTH_LONG).show();
							} else {
								tentativas++;
								tvTentativas.setText(tentativas+" Tentativas");
								Toast.makeText(getApplicationContext(),
										"O número é maior",
										Toast.LENGTH_LONG).show();								
							}
						}
					}
				} catch (NumberFormatException e) {
					Toast.makeText(getApplicationContext(), "Digite um número válido", 
							Toast.LENGTH_LONG).show();
				}
			}
		});
		
		btnNovo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				startActivity(getIntent());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_principal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
