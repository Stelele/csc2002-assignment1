public class LSData<T extends Comparable<T>>
{
    private T area;
    private T regions;
    
    public LSData(T area, T regions)
    {
        this.area = area;
        this.regions = regions;
    }
    
    public T getArea()
    {
        return area;
    }
    
    public T getRegions()
    {
        return regions;
    }
    
    public void setArea(T area)
    {
        this.area = area;
    }
    
    public void setRegions(T regions)
    {
        this.regions = regions;
    }
    
    public String toString()
    {
        return area.toString() + " " + regions.toString();
    }
    
    public int compareTo(LSData<T> data)
    {
        return data.area.compareTo(area);
    }
}