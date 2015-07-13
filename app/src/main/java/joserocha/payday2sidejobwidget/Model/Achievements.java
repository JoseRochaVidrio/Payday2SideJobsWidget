package joserocha.payday2sidejobwidget.Model;

/**
 * Created by Photodynamics5 on 7/9/2015.
 */
public class Achievements {
    public int ID;
    public String Icon;
    public String Name;
    public String Code;
    public String Information;

    public int getID(){
        return this.ID;
    }
    public String getIcon(){
        return this.Icon;
    }
    public String getName(){
        return this.Name;
    }
    public String getCode(){
        return this.Code;
    }
    public String getInformation() {return this.Information;}

    public void setID(int ID){
        this.ID = ID;
    }
    public void setIcon(String Icon){
        this.Icon = Icon;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setCode(String Code){
        this.Code = Code;
    }
    public void setInformation(String Information){this.Information = Information;}
}
