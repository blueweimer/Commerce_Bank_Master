import {useState} from 'react';
import Calendar from 'react-calendar';
//import './App.css';
import 'react-calendar/dist/Calendar.css'



function ShowCalendar(props) {

  const [date, setDate] = useState(new Date())
    let [showResult, setShowResult] = useState("")

    const submitDay =()=>{

        console.log("day " + date.toDateString())
        fetch('http://localhost:8081/showDay/'+ date.toDateString(),{
            method:'GET',
        })
            .then(res=> {
                    if (res.ok) {
                        res.text().then(text => {
                            console.log(text);
                            setShowResult(text);
                        });
                    }
                }
            )
    }

    return (
        <div className="app">
            <h1 className="header">React Calendar</h1>
            <div className="calendar-container">
                <Calendar onChange={setDate} value={date} onClickDay={() => submitDay()}/>
            </div>
            <div className="text-center">
                Selected date: {date.toDateString()}
                Result date: {showResult}
            </div>
        </div>
    )

}



export default ShowCalendar;
