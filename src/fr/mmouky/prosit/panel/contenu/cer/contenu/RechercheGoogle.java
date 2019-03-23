package fr.mmouky.prosit.panel.contenu.cer.contenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RechercheGoogle {

	private boolean errorBatch;
	private Process p;
	private Runtime r;

	public RechercheGoogle() {
		setErrorBatch(false);
		try {
			r = Runtime.getRuntime();
			String[] command = { "powershell.exe", "/C", "start .\\src\\fr\\mmouky\\prosit\\KWPM-Api-master\\run.bat" };
			setP(r.exec(command));
			p.waitFor();
		} catch (Exception e) {
			setErrorBatch(true);
			System.out.println("erreur d'execution");
		}
	}

	public String recherche(String txt, int err) {
		try {
			URL url = new URL("http://localhost:3000/wiki/" + txt);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			con.disconnect();
			String resp = new String(content.toString().getBytes("iso-8859-1"), "utf8");
			resp = resp.substring(1);
			resp = resp.substring(0, resp.length() - 1);
			return resp.toString();
		} catch (IOException e) {
			if (isErrorBatch()) {
				e.printStackTrace();
				return null;
			} else {
				if (err < 10) {
					if (e.getCause() != null) {
						return recherche(txt, err + 1);
					} else {
						return null;
					}
				} else {
					return null;
				}

			}
		}

	}

	public void stop() {

	}

	public boolean isErrorBatch() {
		return errorBatch;
	}

	public void setErrorBatch(boolean errorBatch) {
		this.errorBatch = errorBatch;
	}

	public Process getP() {
		return p;
	}

	public void setP(Process p) {
		this.p = p;
	}

}
