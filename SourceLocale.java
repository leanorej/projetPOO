package projetpoo;

public class SourceLocale implements SourceAudio {
    private String chemin;

    public SourceLocale(String c) {
        this.chemin = c;
    }

    public String getC(){
    	return chemin;
    }
    public void setC(String c){
    	this.chemin = c;
    }

    @Override
    public Playlist filtrer(Playlist dossier) {
        return dossier;
    }

}