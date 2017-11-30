public class PetSold extends ItemSold {
    
    private boolean vaccinated;
    public boolean isVaccinated () { return vaccinated; }
    public void setVaccinated (boolean vaccinated) { this.vaccinated = vaccinated; }
    
    private boolean neutered;
    public boolean isNeutered () { return neutered; }
    public void setNeutered (boolean neutered) { this.neutered = neutered; }
    
    private boolean houseBroken;
    public boolean isHouseBroken () { return houseBroken; }
    public void setHouseBroken (boolean houseBroken) { this.houseBroken = houseBroken; }
    
}
