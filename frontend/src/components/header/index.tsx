import './styles.css';
import calezaniLogo from '../../assets/calezani-logo.jpg';
import { Link } from 'react-router-dom';

export default function Header() {
    return (
        <header>
            <nav className='container'>
                <div className="header-logo">
                    <img src={calezaniLogo} alt="Calezani logo" />
                </div>
                <div className="header-link">
                    <Link to="/assessments">
                        Ver avaliações
                    </Link>
                </div>
            </nav>
        </header>
    );
}