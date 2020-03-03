/**
 * class that stores the data for a given entry
 * */
public class LSData<T extends Comparable<T>>
{
    private T area;
    private T regions;
    
    /**
     * @param area <code>T</code> represents the key fieild of object
     * @param regions <code>T</code> represents the various regions for the specified key
     * */
    public LSData(T area, T regions)
    {
        this.area = area;
        this.regions = regions;
    }
    
    /**
     * @return area <code>T</code> represents the key field of the object
     * */
    public T getArea()
    {
        return area;
    }
    
    /**
     * @return regions <code>T</code> represents the various regions of the specified key
     * */
    public T getRegions()
    {
        return regions;
    }
    
    /**
     * @param area <code>T</code> represents new key field for given object
     * */
    public void setArea(T area)
    {
        this.area = area;
    }
    
    /**
     * @param regions <code>T</code> represents new regions for specified key
     * */
    public void setRegions(T regions)
    {
        this.regions = regions;
    }
    
    /**
     * @return value <code>String</code> represents string representation of the object properties
     * */
    public String toString()
    {
        return area.toString() + " " + regions.toString();
    }
    
    /**
     * function that compares the key field of the LSData class
     * @param data <code>LSData<T></code> represents the object to be compared to with
     * @return comparison <code>int<code> represent the result of the key comparisons
     * */
    public int compareTo(LSData<T> data)
    {
        return data.area.compareTo(area);
    }
}
