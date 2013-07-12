object Options {

  case class Employee(name: String, department: Option[Department])

  case class Department(name: String, director: Option[Employee])

  def findEmployee(name: String): Option[Employee] = null

  for {emp <- findEmployee("blah")
       dept <- emp.department
       director <- dept.director
  } yield (director.name)


  val emp = findEmployee("blah")

  findEmployee("blah") match {
    case None => None
    case Some(emp) => emp.department match {
      case None => None
      case Some(dept) => dept.director match {
        case None => None
        case Some(director) => Some(director.name)
      }
    }
  }


  def bind[A, B](option: Option[A], f: A => Option[B]): Option[B] = {
    option match {
      case None => None
      case Some(a) => f(a)
    }
  }

  bind(findEmployee("blah"), {
    (emp: Employee) => bind(emp.department, {
      (dept: Department) => bind(dept.director, {
        (head: Employee) => Some(head.name)
      })
    }
    )
  })
}