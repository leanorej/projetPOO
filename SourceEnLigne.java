package projetpoo;

public class SourceEnLigne implements SourceAudio {
    private String url;

    public SourceEnLigne(String url){
        this.url = url;
    }

    public String getU(){
    	return url; 
    }
    public void setU(String url){
    	this.url = url;
    }
    	

    @Override
    public Playlist filtrer(Playlist dossier) {
        return dossier;
    }


}