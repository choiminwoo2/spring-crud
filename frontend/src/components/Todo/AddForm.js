import styled from './AddForm.module.css'
const AddForm = (props) => {


const cancelBtnHandler = () =>{

} 

    return(
    <form className={styled['form-size']}>
        <div className={styled['form-controls']}>
            <div className={styled['form-control']}>
                <label htmlFor="todo">할일 입력</label>
                <input type="text" id="todo" /> 
            </div>
        </div>
        <div className="new-expense__actions">
          <button type="submit" onClick={cancelBtnHandler}>취소</button>
          <button type="submit">추가</button>
      </div>
    </form>
    )
} 

export default AddForm;