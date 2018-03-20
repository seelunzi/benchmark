/*    */
package com.tangtang.trade.hry.web.log.model;
/*    */
/*    */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
@Table(name = "student")
/*    */ public class Student
        /*    */ extends BaseModel
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Long id;
    /*    */
    @Column(name = "name")
    /*    */ private String name;
    /*    */
    @Column(name = "sex")
    /*    */ private Integer sex;
    /*    */
    @Column(name = "age")
    /*    */ private Integer age;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 44 */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setId(Long id)
    /*    */ {
        /* 51 */
        this.id = id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public String getName()
    /*    */ {
        /* 58 */
        return this.name;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setName(String name)
    /*    */ {
        /* 65 */
        this.name = name;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public Integer getSex()
    /*    */ {
        /* 72 */
        return this.sex;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setSex(Integer sex)
    /*    */ {
        /* 79 */
        this.sex = sex;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public Integer getAge()
    /*    */ {
        /* 86 */
        return this.age;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setAge(Integer age)
    /*    */ {
        /* 93 */
        this.age = age;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\log\model\Student.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */