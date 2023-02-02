package callbus.zaritalk.dataaccesslayer.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "community")
@Getter
@Setter
@ToString
@Builder
public class Community extends BaseEntity{

    @ManyToOne
    @Column(name = "writer")
    Users writer;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "like")
    int like = 0;

    @Column(name = "status")
    boolean status = true;

    @Column(name = "deleted_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    Timestamp deletedDate = null;
}