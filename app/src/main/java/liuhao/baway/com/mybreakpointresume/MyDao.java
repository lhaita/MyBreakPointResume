package liuhao.baway.com.mybreakpointresume;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 15218 on 2017/11/22.
 */
@Entity
public class MyDao {
    @Id
    private Long id ;
    private int currPosition ;
    private int currLength ;
    public int getCurrLength() {
        return this.currLength;
    }
    public void setCurrLength(int currLength) {
        this.currLength = currLength;
    }
    public int getCurrPosition() {
        return this.currPosition;
    }
    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1598379958)
    public MyDao(Long id, int currPosition, int currLength) {
        this.id = id;
        this.currPosition = currPosition;
        this.currLength = currLength;
    }
    @Generated(hash = 327307982)
    public MyDao() {
    }

    @Override
    public String toString() {
        return "MyDao{" +
                "id=" + id +
                ", currPosition=" + currPosition +
                ", currLength=" + currLength +
                '}';
    }
}
