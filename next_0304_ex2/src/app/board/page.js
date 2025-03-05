import BbsTr from "@/component/BbsTr";

export default function Page(){

    let ar = [
        {title:"NextJS활용", writer:"일지매"},
        {title:"프론트엔드", writer:"이지매"},
        {title:"뭐지?", writer:"삼지매"}
    ]
    return(
        <div>
            <h1 className="title">게시판</h1>
            <hr/>
            <table className="t1">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>등록일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                   
                    {ar.map( (item, idx) => (
                      
                        <BbsTr num={idx} title={item.title} name={item.writer} key={idx}/>
                    ))}
                </tbody>
            </table>

        </div>
    );
}