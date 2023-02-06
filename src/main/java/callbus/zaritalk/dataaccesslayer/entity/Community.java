package callbus.zaritalk.dataaccesslayer.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "community")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Community extends BaseEntity{

    @JoinColumn(name = "writer")
    @OneToOne
    private User writer;

    @Column(name = "writer_name")
    private String writerName;

    @Column(name = "community_title")
    private String communityTitle;

    @Column(name = "community_content")
    private String communityContent;

    @Column(name = "like_count")
    private int likeCount = 0;

    @JsonProperty
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name = "deleted_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp deletedDate = null;
}