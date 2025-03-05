import Link from "next/link";
import "../css/style.css"
import MenuItem from "./Menu";

function MyHeader(){
    return(
     <>
        <div>LOGO</div>
        <div className="nav">
            {/* <Link href="/">Home</Link>
            <Link href="/content">Content</Link>
            <Link href="/blog">Blog</Link>
            <Link href="/about">About</Link> */}
            <MenuItem/>
        </div>
     </>
    );
}
export default MyHeader;
