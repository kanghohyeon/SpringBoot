import Link from "next/link";
import "../css/style.css"


function MenuItem(){

    const Link_item =[
        {path:"/",title:"Home"},
        {path:"/content",title:"Content"},
        {path:"/blog",title:"Blog"},
        {path:"/about",title:"About"}
    ];

    return(
        <>
            {Link_item.map((item)=>( 
                // 중괄호 리턴을 생략해서 소괄호로 바로 사용 가능
                <span key={item.path}>

                    <Link  href={item.path}>{item.title}</Link>
                    &nbsp;&nbsp;&nbsp;
                 </span>
                
            ))}
           
        </>
    );

}
export default MenuItem;